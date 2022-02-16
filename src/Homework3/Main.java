package Homework3;

public class Main {
    public static void main(String[] args) {
        AutoDealer autoDealer = new AutoDealer();
        autoDealer.orderCar(AutoFactory.Colors.RED, AutoFactory.Models.MERCEDES, 2021, 17, 2.5).printCarInfo();
        Car car = new Car(AutoFactory.Colors.YELLOW, AutoFactory.Models.BMW, 2021, 17, 3.0);
        System.out.println(autoDealer.changeCarWheels(car, 16));
        System.out.println(autoDealer.changeColor(car, AutoFactory.Colors.GRAY));

    }
}
