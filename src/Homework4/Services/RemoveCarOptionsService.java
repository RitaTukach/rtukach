package Homework4.Services;

import Homework4.Cars.Car;
import Homework4.Parameters.CarOptions;

public class RemoveCarOptionsService implements Service<CarOptions> {
        @Override
        public void doService(Car car, CarOptions value) {
            car.removeCarOptions(value);
        }
}
