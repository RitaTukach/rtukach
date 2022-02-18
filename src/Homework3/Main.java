package Homework3;

public class Main {
    public static void main(String[] args) {
        AutoDealer autoDealer = new AutoDealer();
        autoDealer.orderCar(Colors.RED, Models.MERCEDES, 2021, 18, 2.5, CarOptions.BLUETOOTH).printCarInfo();
        Car car = new Car(Colors.YELLOW, Models.BMW, 2021, 17, 3.0, CarOptions.NO_OPTION);
        autoDealer.setWheelSize(car, 16);
        autoDealer.setColor(car, Colors.GRAY);
        autoDealer.setCarOptions(car, CarOptions.CAMERA);
        System.out.println(car);
    }
}
