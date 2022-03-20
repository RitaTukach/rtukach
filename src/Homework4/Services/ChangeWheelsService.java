package Homework4.Services;

import Homework4.Cars.Car;
import Homework4.Parameters.WheelSize;

public class ChangeWheelsService implements Service<WheelSize> {

    @Override
    public void doService(Car car, WheelSize value) {
        car.setWheelSize(value);
    }
}
