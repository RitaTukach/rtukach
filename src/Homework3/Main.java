package Homework3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        AutoDealer autoDealer = new AutoDealer();
        autoDealer.orderCar(Colors.RED, Models.MERCEDES, 2021, 18, 2.5, new HashSet<>()).printCarInfo();
        Car car = new Car(Colors.YELLOW, Models.BMW, 2021, 17, 3.0, null);
        autoDealer.setWheelSize(car, 16);
        autoDealer.setColor(car, Colors.GRAY);
        autoDealer.setCarOptions(car, new HashSet<>());
        System.out.println(car);
    }
}
