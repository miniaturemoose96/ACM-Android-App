package com.example.acm_app_alejandro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hackathon {

    @SerializedName("array")
    List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

}
