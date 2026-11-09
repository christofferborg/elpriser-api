package com.elpris.elprisapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {

    @JsonProperty("SEK_per_kWh")
    private double sekPerKwh;
    @JsonProperty("time_start")
    private String timeStart;

    public double getSekPerKwh(){
        return sekPerKwh;
    }
}
