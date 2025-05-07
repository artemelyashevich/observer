package com.elyashevich.patterns.observer.event;

public class WeatherEvent {
    private final String weather;

    public WeatherEvent(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }
}