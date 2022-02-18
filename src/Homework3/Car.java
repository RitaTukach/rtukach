package Homework3;

public class Car {
    private Colors color;
    private final Models model;
    private final int year;
    private int wheelSize;
    private final double engineVolume;
    private CarOptions carOptions;

    public Car(Colors color, Models model, int year, int wheelSize, double engineVolume,
               CarOptions carOptions) {
        this.color = color;
        this.model = model;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
        this.carOptions = carOptions;
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

    public CarOptions getCarOptions() {
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

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setCarOptions(CarOptions carOptions) {
        this.carOptions = carOptions;
    }
}

