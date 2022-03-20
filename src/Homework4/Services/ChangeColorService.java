package Homework4.Services;

import Homework4.Cars.Car;
import Homework4.Parameters.Colors;

public class ChangeColorService implements Service<Colors> {
    @Override
    public void doService(Car car, Colors value) {
        car.setColor(value);
    }
}
