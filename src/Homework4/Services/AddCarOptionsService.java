package Homework4.Services;

import Homework4.Cars.Car;
import Homework4.Parameters.CarOptions;

public class AddCarOptionsService implements Service<CarOptions> {
    @Override
    public void doService(Car car, CarOptions value) {
        car.addCarOptions(value);
    }
}
