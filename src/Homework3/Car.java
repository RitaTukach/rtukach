package Homework3;

import java.util.Collections;
import java.util.HashSet;

public class Car {
    private Colors color;
    private final Models model;
    private final int year;
    private WheelSize wheelSize;
    private final EngineVolumes engineVolume;
    private HashSet<CarOptions> carOptionsList;

    public Car(Colors color, Models model, int year, WheelSize wheelSize, EngineVolumes engineVolume) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
        Collections.addAll(carOptionsList, CarOptions.CAMERA, CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING);
        if (carOptionsList == null) {
            carOptionsList = null;
        }
    }

    public Car(Colors color, Models model, int year, WheelSize wheelSize, EngineVolumes engineVolume,
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

    public Colors getColor() {
        return color;
    }

    public Models getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public EngineVolumes getEngineVolume() {
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

    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setCarOptionsList(HashSet<CarOptions> carOptionsList) {
        this.carOptionsList = carOptionsList;
    }

    public void addCarOptions(CarOptions carOption) {
        if(carOptionsList != null) {
            carOptionsList.add(carOption);
        } else {
            setCarOptionsList(new HashSet<>());
            carOptionsList.add(carOption);
        }
    }

    public HashSet<CarOptions> removeCarOptions(CarOptions carOption) {
        if(carOptionsList == null) {
            throw new NullPointerException("Cannot remove option from empty car options list");
        } else {
            carOptionsList.remove(carOption);
        }
        return carOptionsList;
    }
}

