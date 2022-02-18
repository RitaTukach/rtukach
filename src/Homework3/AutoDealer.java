package Homework3;

import java.util.HashSet;

public class AutoDealer extends AutoFactory{

    public Car orderCar(Colors color, Models model, int year, int wheelSize, double engineVolume, HashSet<CarOptions> carOptionsList) {
        AutoFactory autoFactory = new AutoFactory();
        autoFactory.printFactoryCarParameters();
        return autoFactory.createCar(color, model, year, wheelSize, engineVolume, carOptionsList);
    }
}
