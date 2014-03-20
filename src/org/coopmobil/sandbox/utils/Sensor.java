package org.coopmobil.sandbox.utils;

public class Sensor {
    private String sensorName;
    private int sensorType;

    public Sensor(String sensorName,int sensorType) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
    }

    public String getSensorName() {
        return sensorName;
    }

    public int getSensorType() {
        return sensorType;
    }
}
