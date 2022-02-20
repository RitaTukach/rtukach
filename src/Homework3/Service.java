package Homework3;

public class Service {

    public Service() {
    }

    public void changeColor(Car car, Colors color) {
        car.setColor(color);
    }

    public void changeWheelSize(Car car, WheelSize wheelSize) {
        car.setWheelSize(wheelSize);
    }

    public void addCarOptions(Car car, CarOptions carOption) {
        car.addCarOptions(carOption);
    }

    public void removeCarOptions(Car car, CarOptions carOption) {
        car.removeCarOptions(carOption);
    }
}
