package com.elyashevich.patterns.observer.subscriber;

import com.elyashevich.patterns.observer.Subscribe;
import com.elyashevich.patterns.observer.event.WeatherEvent;

public class WeatherSubscriber {
    @Subscribe
    public void handleWeather(WeatherEvent event) {
        System.out.println("Weather Update: " + event.getWeather());
    }
}