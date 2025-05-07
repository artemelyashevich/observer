package com.elyashevich.patterns.observer.event;

public class NewsEvent {
    private final String news;

    public NewsEvent(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}