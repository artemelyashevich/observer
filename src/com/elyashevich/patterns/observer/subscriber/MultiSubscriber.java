package com.elyashevich.patterns.observer.subscriber;

import com.elyashevich.patterns.observer.Subscribe;
import com.elyashevich.patterns.observer.event.NewsEvent;
import com.elyashevich.patterns.observer.event.WeatherEvent;

public class MultiSubscriber {
    @Subscribe
    public void handleNews(NewsEvent event) {
        System.out.println("MultiSubscriber received news: " + event.getSource());
    }

    @Subscribe
    public void handleWeather(WeatherEvent event) {
        System.out.println("MultiSubscriber received weather: " + event.getSource());
    }
}
