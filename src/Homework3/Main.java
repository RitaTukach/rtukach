package Homework3;

public class Main {
    public static void main(String[] args) {
        AutoDealer autoDealer = new AutoDealer();
        autoDealer.orderCar(AutoFactory.Colors.RED, AutoFactory.Models.MERCEDES, 2021, 18, 2.5, AutoFactory.CarOptions.BLUETOOTH).printCarInfo();
        Car car = new Car(AutoFactory.Colors.YELLOW, AutoFactory.Models.BMW, 2021, 17, 3.0, AutoFactory.CarOptions.NO_OPTION);
        autoDealer.setWheelSize(car, 16);
        autoDealer.setColor(car, AutoFactory.Colors.GRAY);
        autoDealer.setCarOptions(car, AutoFactory.CarOptions.CAMERA);
        System.out.println(car);
    }
}
