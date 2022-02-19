package Homework3;

import java.util.HashSet;

public class AutoDealer {

    public Car orderCar(AutoFactory autoFactory, Colors color, Models model, int year, WheelSize wheelSize, EngineVolumes engineVolume,
                        HashSet<CarOptions> carOptionsList) {
        autoFactory.createCar(color, model, year, wheelSize,  engineVolume, carOptionsList);
        return new Car(color, model, year, wheelSize,  engineVolume, carOptionsList);
    }
    public void changeColor(Service service, Car car, Colors color) {
        service.changeColor(car, color);
    }
    public void changeWheelSize(Service service, Car car, WheelSize wheelSize) {
        car.setWheelSize(wheelSize);
    }
    public void addCarOptions(Service service, Car car, CarOptions carOption) {
        service.addCarOptions(car, carOption);
    }
    public void removeCarOptions(Service service, Car car, CarOptions carOption) {
        service.removeCarOptions(car, carOption);
    }
}
