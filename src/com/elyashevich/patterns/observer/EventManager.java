package com.elyashevich.patterns.observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<Class<?>, List<Subscriber>> subscribers = new HashMap<>();

    public void register(Object observer) {
        Class<?> observerClass = observer.getClass();
        for (Method method : observerClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException(
                        "Method " + method + " has @Subscribe annotation but requires " + 
                        parameterTypes.length + " parameters. Subscriber methods must require exactly 1 parameter.");
                }

                Class<?> eventType = parameterTypes[0];
                subscribers.computeIfAbsent(eventType, k -> new ArrayList<>())
                          .add(new Subscriber(observer, method));
            }
        }
    }

    public void unregister(Object observer) {
        for (List<Subscriber> subscriberList : subscribers.values()) {
            subscriberList.removeIf(subscriber -> subscriber.observer == observer);
        }
    }

    public void post(Object event) {
        Class<?> eventType = event.getClass();
        List<Subscriber> eventSubscribers = subscribers.get(eventType);
        
        if (eventSubscribers != null) {
            for (Subscriber subscriber : eventSubscribers) {
                subscriber.invoke(event);
            }
        }
    }

    private static class Subscriber {
        private final Object observer;
        private final Method method;

        Subscriber(Object observer, Method method) {
            this.observer = observer;
            this.method = method;
            this.method.setAccessible(true);
        }

        void invoke(Object event) {
            try {
                method.invoke(observer, event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Unable to invoke subscriber method", e);
            }
        }
    }
}