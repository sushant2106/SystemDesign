package com.sushant.properties.encapsulation;

public class Temperature {

    private double celsius;

    public Temperature(double celsius){
        setCelsius(celsius);
    }

    public void setCelsius(double celsius){
        if (celsius < -273.15) {
            throw new IllegalArgumentException(
                    "Temperature cannot be below absolute zero"
            );
        }

        this.celsius=celsius;
    }

    public double getCelsius() {
        return celsius;
    }
}
