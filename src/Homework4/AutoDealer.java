package Homework4;

import Homework4.Cars.Car;
import Homework4.Cars.SportsCar;
import Homework4.Factories.AutoFactory;
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

public class AutoDealer<T> {

    private ChangeColorService changeColorService;
    private ChangeWheelsService changeWheelsService;
    private RemoveCarOptionsService removeCarOptionsService;
    private AddCarOptionsService addCarOptionsService;
    private final StorageImpl sportCarsStorage = new StorageImpl();
    List<SportsCar> carsList = new ArrayList<>(sportCarsStorage.getCarsStorageList());;
    private TruckCarFactory truckCarFactory ;
    private PassengerCarFactory passengerCarFactory;
    private SportsCarFactory sportsCarFactory;
    private AutoFactory autoFactory;
    private RacingTypes racingTypes;
    private PassengerCarTypes passengerCarTypes;
    private CargoTypes cargoTypes;

    public AutoDealer(TruckCarFactory truckCarFactory, PassengerCarFactory passengerCarFactory, SportsCarFactory sportsCarFactory,
                      ChangeColorService changeColorService, ChangeWheelsService changeWheelsService,
                      RemoveCarOptionsService removeCarOptionsService, AddCarOptionsService addCarOptionsService) {
        this.truckCarFactory = truckCarFactory;
        this.passengerCarFactory = passengerCarFactory;
        this.sportsCarFactory = sportsCarFactory;
        this.changeColorService = changeColorService;
        this.changeWheelsService = changeWheelsService;
        this.removeCarOptionsService= removeCarOptionsService;
        this.addCarOptionsService = addCarOptionsService;
    }

    public Car orderCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                        HashSet<CarOptions> carOptionsList, T ... ts) {
        Car car = null;
        for (CargoTypes type: CargoTypes.values()) {
            if (ts[0].equals(type)) {
                car = truckCarFactory.createCar(color, model, wheelSize, engineVolume, carOptionsList, ts);
            }
        }
        for (RacingTypes type: RacingTypes.values()) {
            if (ts[0].equals(type)) {
                car = sportsCarFactory.createSportsCar(color, model, wheelSize, engineVolume, carOptionsList, racingTypes,
                         passengerCarTypes);
            }
        }
        for (PassengerCarTypes type: PassengerCarTypes.values()) {
            if (ts[0].equals(type)) {
                car = sportsCarFactory.createSportsCar(color, model, wheelSize, engineVolume, carOptionsList, racingTypes,
                        passengerCarTypes);
            }
        }
            return car;
    }

    public void changeColor(Car car, Colors color) {
        changeColorService.doService(car, color);
    }

    public void changeWheelSize(Car car, WheelSize wheelSize) {
        changeWheelsService.doService(car, wheelSize);
    }

    public void addCarOptions(Car car, CarOptions carOption) {
        addCarOptionsService.doService(car, carOption);
    }

    public void removeCarOptions(Car car, CarOptions carOption) {
        removeCarOptionsService.doService(car, carOption);
    }
}
