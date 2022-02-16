package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private AutoFactory.Colors color;
    private final AutoFactory.Models model;
    private final int year;
    private int wheelSize;
    private final double engineVolume;
    String option1;
    String option2;
    private List<String> list = new ArrayList<>(2);

    public Car(AutoFactory.Colors color, AutoFactory.Models model, int year, int wheelSize, double engineVolume) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
    }

    public Car(AutoFactory.Colors color, AutoFactory.Models model, int year, int wheelSize, double engineVolume, List<String> list) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
        this.option1 = String.valueOf(list.add("option1"));
        this.option2 = String.valueOf(list.add("option2"));

    }

    public AutoFactory.Colors getColor() {
        return color;
    }

    public AutoFactory.Models getModel() {
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

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVolume=" + engineVolume +
                ", list=" + list +
                '}';
    }

    public void printCarInfo() {
        System.out.println(this.toString());
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void setColor(AutoFactory.Colors color) {
        this.color = color;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }
}

