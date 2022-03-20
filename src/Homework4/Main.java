package Homework4;

import Homework4.Cars.SportsCar;
import Homework4.Cars.TruckCar;
import Homework4.Cars.PassengerCar;
import Homework4.Factories.PassengerCarFactory;
import Homework4.Factories.SportsCarFactory;
import Homework4.Factories.TruckCarFactory;
import Homework4.Parameters.*;
import Homework4.Services.AddCarOptionsService;
import Homework4.Services.ChangeColorService;
import Homework4.Services.ChangeWheelsService;
import Homework4.Services.RemoveCarOptionsService;
import Homework4.Storages.StorageImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ChangeColorService changeColorService = new ChangeColorService();
        ChangeWheelsService changeWheelsService = new ChangeWheelsService();
        RemoveCarOptionsService removeCarOptionsService = new RemoveCarOptionsService();
        AddCarOptionsService addCarOptionsService = new AddCarOptionsService();
        StorageImpl sportCarsStorage = new StorageImpl();

        SportsCarFactory sportsCarFactory = new SportsCarFactory(changeColorService, changeWheelsService,
                removeCarOptionsService, addCarOptionsService, sportCarsStorage);
        TruckCarFactory truckCarFactory = new TruckCarFactory(changeColorService, changeWheelsService,
                removeCarOptionsService, addCarOptionsService);
        PassengerCarFactory passengerCarFactory = new PassengerCarFactory(changeColorService, changeWheelsService,
                removeCarOptionsService, addCarOptionsService);

        AutoDealer autoDealer = new AutoDealer(truckCarFactory, passengerCarFactory, sportsCarFactory,
                changeColorService, changeWheelsService, removeCarOptionsService,
                addCarOptionsService);

       System.out.println(autoDealer.orderCar(Colors.GRAY, Models.MERCEDES, WheelSize.EIGHTEEN, EngineVolumes.RACING,
                new HashSet<>(Set.of(CarOptions.BLUETOOTH)), RacingTypes.DRIFT, PassengerCarTypes.COUPE));
    }
}
