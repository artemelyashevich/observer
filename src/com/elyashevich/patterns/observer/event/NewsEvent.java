package com.elyashevich.patterns.observer.event;

import java.util.EventObject;

public class NewsEvent extends EventObject {

    public NewsEvent(String source) {
        super(source);
    }

    @Override
    public String getSource() {
        return (String)super.getSource();
    }
}