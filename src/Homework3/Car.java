package Homework3;

public class Car {
    private AutoFactory.Colors color;
    private final AutoFactory.Models model;
    private final int year;
    private int wheelSize;
    private final double engineVolume;
    private AutoFactory.CarOptions carOptions;

    public Car(AutoFactory.Colors color, AutoFactory.Models model, int year, int wheelSize, double engineVolume,
               AutoFactory.CarOptions carOptions) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
        this.carOptions = carOptions;
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

    public AutoFactory.CarOptions getCarOptions() {
        return carOptions;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVolume=" + engineVolume +
                ", CarOptions=" + carOptions +
                '}';
    }

    public void printCarInfo() {
        System.out.println(this.toString());
    }

    public void setColor(AutoFactory.Colors color) {
        this.color = color;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setCarOptions(AutoFactory.CarOptions carOptions) {
        this.carOptions = carOptions;
    }
}

