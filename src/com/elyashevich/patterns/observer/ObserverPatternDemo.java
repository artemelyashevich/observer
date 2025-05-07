package com.elyashevich.patterns.observer;

import com.elyashevich.patterns.observer.event.NewsEvent;
import com.elyashevich.patterns.observer.event.WeatherEvent;
import com.elyashevich.patterns.observer.subscriber.MultiSubscriber;
import com.elyashevich.patterns.observer.subscriber.NewsSubscriber;
import com.elyashevich.patterns.observer.subscriber.WeatherSubscriber;

public class ObserverPatternDemo {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        NewsSubscriber newsSubscriber = new NewsSubscriber();
        WeatherSubscriber weatherSubscriber = new WeatherSubscriber();
        MultiSubscriber multiSubscriber = new MultiSubscriber();

        eventManager.register(newsSubscriber);
        eventManager.register(weatherSubscriber);
        eventManager.register(multiSubscriber);

        eventManager.post(new NewsEvent("1"));
        eventManager.post(new WeatherEvent("2"));
        eventManager.post(new NewsEvent("3"));

        eventManager.unregister(weatherSubscriber);

        System.out.println("\nAfter unregistering weatherSubscriber:");

        eventManager.post(new WeatherEvent("2.1"));
        eventManager.post(new NewsEvent("3.1"));
    }
}