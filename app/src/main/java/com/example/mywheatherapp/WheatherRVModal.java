package com.example.mywheatherapp;

public class WheatherRVModal {
    private String time;
    private String temperature;
    private String icon;
    private String wingSpeed;

    public WheatherRVModal(String time, String temperature, String icon, String wingSpeed) {
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
        this.wingSpeed = wingSpeed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getWingSpeed() {
        return wingSpeed;
    }

    public void setWingSpeed(String wingSpeed) {
        this.wingSpeed = wingSpeed;
    }


}
