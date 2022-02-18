package Homework3;

import java.util.HashSet;

public class Car {
    private Colors color;
    private final Models model;
    private final int year;
    private int wheelSize;
    private final double engineVolume;
    //private CarOptions carOptions;
    private HashSet<CarOptions> carOptionsList;

    public Car(Colors color, Models model, int year, int wheelSize, double engineVolume,
               HashSet<CarOptions> carOptionsList) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
        this.carOptionsList = carOptionsList;
    }

    public HashSet<CarOptions> getCarOptionsList() {
        return carOptionsList;
    }

    public void setCarOptionsList(HashSet<CarOptions> carOptionsList) {
        this.carOptionsList = carOptionsList;
    }

    public Colors getColor() {
        return color;
    }

    public Models getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVolume=" + engineVolume +
                ", CarOptions=" + carOptionsList +
                '}';
    }

    public void printCarInfo() {
        System.out.println(this.toString());
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }
}

