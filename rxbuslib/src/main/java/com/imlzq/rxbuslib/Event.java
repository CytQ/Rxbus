package com.imlzq.rxbuslib;

import android.os.Bundle;

/**
 *
 * Created by lizhongquan on 2017/2/24.
 */
public class Event {

    private String eventName;

    private Bundle eventInfo;

    private String fromPosition;

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventInfo=" + eventInfo +
                ", fromPosition='" + fromPosition + '\'' +
                '}';
    }

    public String getEventName() {
        return eventName;
    }

    public Bundle getEventInfo() {
        return eventInfo;
    }

    public String getFromPosition() {
        return fromPosition;
    }

    public Event(String eventName, Bundle eventInfo, String fromPosition) {

        this.eventName = eventName;
        this.eventInfo = eventInfo;
        this.fromPosition = fromPosition;
    }
}
