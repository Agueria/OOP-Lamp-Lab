package com.example.lab1;

public class Lamp {
    private boolean isOn;
    private int intensity;
    private Bulb bulb;

    public Lamp() {
        this.bulb = new Bulb();
        this.isOn = false;
        this.intensity = 0;
    }

    public void turnOn() {
        if (!bulb.isBurned()) {
            isOn = true;
            if (intensity == 0) {
                intensity = 1;
            }
            bulb.turnOn();
        }
    }

    public void turnOff() {
        isOn = false;
        intensity = 0;
        bulb.turnOff();
    }

    public void brighten() {
        if (isOn) {
            intensity++;
            if (intensity > 10) {
                bulb.burn();
                bulb.turnOff();
                isOn = false;
                intensity = 0;
            }
        }
    }

    public void dim() {
        if (isOn) {
            intensity--;
            if (intensity <= 0) {
                turnOff();
            }
        }
    }

    public boolean replaceBulb() {
        if (!isOn) {
            bulb = new Bulb();
            return true;
        }
        return false;
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isShining() {
        return isOn && intensity > 0 && bulb.isOn();
    }

    public boolean isBulbBurned() {
        return bulb.isBurned();
    }

    public int getIntensity() {
        return intensity;
    }
}
