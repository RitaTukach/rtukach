package Homework3;

public class AutoDealer extends AutoFactory{

    public Car orderCar(Colors color, Models model, int year, int wheelSize, double engineVolume) {
        AutoFactory autoFactory = new AutoFactory();
        autoFactory.printFactoryCarParameters();
        return autoFactory.createCar(color, model, year, wheelSize, engineVolume);
    }

    public Car changeCarWheels(Car car, int newWheelSize) {
        if (car != null) {
            car.setWheelSize(newWheelSize);
        }
        return car;
    }
    public Car changeColor(Car car, Colors newColor) {
        if (car != null) {
            car.setColor(newColor);
        }
        return car;
    }
}
