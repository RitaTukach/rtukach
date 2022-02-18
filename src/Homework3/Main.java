package Homework3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AutoDealer autoDealer = new AutoDealer();
        autoDealer.orderCar(Colors.RED, Models.MERCEDES, 2021, 18, 2.5,
                  new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING))).printCarInfo();
        Car car = new Car(Colors.YELLOW, Models.BMW, 2021, 19, 3.0, null);
        autoDealer.setWheelSize(car, 16);
        autoDealer.setColor(car, Colors.GRAY);
        autoDealer.setCarOptions(car, new HashSet<>(Set.of(CarOptions.WHEEL_HEATING)));
        System.out.println(car);
    }
}
