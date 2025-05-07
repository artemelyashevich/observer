package com.elyashevich.patterns.observer.subscriber;

import com.elyashevich.patterns.observer.Subscribe;
import com.elyashevich.patterns.observer.event.NewsEvent;

public class NewsSubscriber {
    @Subscribe
    public void handleNews(NewsEvent event) {
        System.out.println("News Update: " + event.getNews());
    }
}