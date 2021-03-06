package Homework3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        AutoFactory autoFactory = new AutoFactory(service);
        AutoDealer autoDealer = new AutoDealer(service, autoFactory);
        autoDealer.orderCar(autoFactory, Colors.RED, Models.MERCEDES, 2021, WheelSize.EIGHTEEN, EngineVolumes.RACING,
                  new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING))).printCarInfo();
        Car car = new Car(Colors.YELLOW, Models.BMW, 2021, WheelSize.SEVENTEEN, EngineVolumes.RACING, null);
        autoFactory.changeColor(service, car, Colors.WHITE);
        autoDealer.addCarOptions(service, car, CarOptions.BLUETOOTH);
        autoDealer.removeCarOptions(service, car, CarOptions.BLUETOOTH);
    }
}
