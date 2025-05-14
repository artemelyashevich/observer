package com.elyashevich.patterns.observer.event;

import java.util.EventObject;

public class WeatherEvent extends EventObject {

    public WeatherEvent(String source) {
        super(source);
    }

    @Override
    public String getSource() {
        return (String)super.getSource();
    }
}