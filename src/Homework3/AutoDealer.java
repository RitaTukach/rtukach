package Homework3;

public class AutoDealer extends AutoFactory{

    public Car orderCar(Colors color, Models model, int year, int wheelSize, double engineVolume, CarOptions carOptions) {
        AutoFactory autoFactory = new AutoFactory();
        autoFactory.printFactoryCarParameters();
        return autoFactory.createCar(color, model, year, wheelSize, engineVolume, carOptions);
    }
}
