package Homework4.Factories;

import Homework4.Cars.Car;
import Homework4.Cars.PassengerCar;
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

public class PassengerCarFactory<T> extends AutoFactory<T> {

    private ArrayList<PassengerCar> listOfFactoryCandidateCars = new ArrayList<>();
    private PassengerCarTypes passengerCarTypes;
    public StorageImpl<PassengerCar> passengerCarStorage = new StorageImpl<>();

    private final List<PassengerCar> listOfFactoryCars = new ArrayList<>(Set.of(
            new PassengerCar(Colors.YELLOW, Models.MERCEDES, WheelSize.FIFTEEN, EngineVolumes.RACING, null, PassengerCarTypes.COUPE),
            new PassengerCar(Colors.WHITE, Models.MERCEDES, WheelSize.FOURTEEN, EngineVolumes.REGULAR,
                    new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING)), PassengerCarTypes.MINIVAN),
            new PassengerCar(Colors.WHITE, Models.MERCEDES, WheelSize.FOURTEEN, EngineVolumes.REGULAR,
                    new HashSet<>(Set.of(CarOptions.BLUETOOTH)), PassengerCarTypes.SEDAN)));

    public PassengerCarFactory(ChangeColorService changeColorService, ChangeWheelsService changeWheelsService,
                           RemoveCarOptionsService removeCarOptionsService, AddCarOptionsService addCarOptionsService) {
        super(changeColorService, changeWheelsService, removeCarOptionsService, addCarOptionsService);
        this.passengerCarStorage = passengerCarStorage;
        passengerCarStorage.addToStorage(listOfFactoryCars);
    }

    @Override
    public void printFactoryCarParameters() {
        super.printFactoryCarParameters();
        System.out.println("Passenger Types types are: " + passengerCarTypes);
    }

    @Override
    public ArrayList<PassengerCar> checkUnchangeableParameters(Models model, EngineVolumes engineVolume) {
        for (PassengerCar storageCar : passengerCarStorage.getCarsStorageList()) {
            if (storageCar.getModel().equals(model) &&
                    storageCar.getEngineVolume() == engineVolume) {
                listOfFactoryCandidateCars.add(storageCar);
            }
        }
        return listOfFactoryCandidateCars;
    }

    public PassengerCar createPassengerCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                                   HashSet<CarOptions> carOptionsList, PassengerCarTypes passengerCarTypes) {
        PassengerCar car = null;
        if (!(passengerCarStorage.getCarsStorageList().size() == 0)) {
            checkUnchangeableParameters(model, engineVolume);
        } else {
            return new PassengerCar(color, model, wheelSize, engineVolume, carOptionsList, passengerCarTypes);
        }
        if (!(listOfFactoryCandidateCars.isEmpty())) {
            car = searchForMostSuitableFactoryCar(color, wheelSize, carOptionsList);
            if (car == null) {
                car = (PassengerCar) passengerCarStorage.getFromStorage();
                changeColor(car, color);
                changeWheelSize(car, wheelSize);
                setCarOptions(car, carOptionsList);
                return (PassengerCar) car;
            } else {
                passengerCarStorage.getFromStorage();
                setCarParameters(car, color, wheelSize, carOptionsList);
            }
        } else {
            car = new PassengerCar(color, model, wheelSize, engineVolume, carOptionsList, passengerCarTypes);
        }
        return (PassengerCar) car;
    }

    @Override
    public PassengerCar searchForMostSuitableFactoryCar(Colors color, WheelSize wheelSize, HashSet carOptionsList) {
        PassengerCar car = null;
        for (Car storageCar :  listOfFactoryCandidateCars) {
            if (storageCar.getColor().equals(color) && storageCar.getWheelSize() == wheelSize &&
                    storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (PassengerCar) storageCar;
                passengerCarStorage.removeFromStorage((PassengerCar) storageCar);
                return car;
            }
        }
        for (Car storageCar :  listOfFactoryCandidateCars) {
            if ((!(storageCar.getColor().equals(color)) && (storageCar.getWheelSize() == wheelSize) &&
                    storageCar.getCarOptionsList().equals(carOptionsList)) || (storageCar.getColor().equals(color)
                    && storageCar.getCarOptionsList().equals(carOptionsList) && (storageCar.getWheelSize() != wheelSize))) {
                car = (PassengerCar) storageCar;
            }
            else if (!(storageCar.getColor().equals(color)) && storageCar.getWheelSize() == wheelSize &&
                    !(storageCar.getCarOptionsList().equals(carOptionsList)) || storageCar.getColor().equals(color) &&
                    storageCar.getWheelSize() != wheelSize && storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (PassengerCar) storageCar;
            }
            else if (storageCar.getColor().equals(color) && storageCar.getWheelSize() != wheelSize &&
                    !(storageCar.getCarOptionsList().equals(carOptionsList)) || !(storageCar.getColor().equals(color)) &&
                    storageCar.getWheelSize() != wheelSize && storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (PassengerCar) storageCar;
            }
        }
        passengerCarStorage.removeFromStorage(car);
        return car;
    }

    @Override
    public void setCarParameters(Car car, Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptions) {
        super.setCarParameters(car, color, wheelSize, carOptions);
    }

    @Override
    public void setCarOptionsList(HashSet<CarOptions> carOptionsList) {
        super.setCarOptionsList(carOptionsList);
    }

    @Override
    public void changeColor(Car car, Colors color) {
        super.changeColor(car, color);
    }

    @Override
    public void changeWheelSize(Car car, WheelSize wheelSize) {
        super.changeWheelSize(car, wheelSize);
    }

    @Override
    public void addCarOptions(Car car, CarOptions carOption) {
        super.addCarOptions(car, carOption);
    }

    @Override
    public void removeCarOptions(Car car, CarOptions carOption) {
        super.removeCarOptions(car, carOption);
    }

    @Override
    public void setCarOptions(Car car, HashSet<CarOptions> carOptionsList) {
        super.setCarOptions(car, carOptionsList);
    }
}
