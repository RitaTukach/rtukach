package Homework4.Factories;

import Homework4.Cars.Car;
import Homework4.Cars.SportsCar;
import Homework4.Parameters.*;
import Homework4.Services.AddCarOptionsService;
import Homework4.Services.ChangeColorService;
import Homework4.Services.ChangeWheelsService;
import Homework4.Services.RemoveCarOptionsService;
import Homework4.Storages.StorageImpl;
import java.util.*;

public class SportsCarFactory<T> extends AutoFactory<T> {

    private ArrayList<SportsCar> listOfFactoryCandidateCars = new ArrayList<>();
    private RacingTypes racingTypes;
    private PassengerCarTypes passengerCarTypes;
    public StorageImpl<SportsCar> sportsCarStorage = new StorageImpl<>();

    private final List<SportsCar> listOfFactoryCars = new ArrayList<>(Set.of(
            new SportsCar(Colors.YELLOW, Models.MERCEDES, WheelSize.FIFTEEN, EngineVolumes.RACING, null, RacingTypes.DRAG,
            PassengerCarTypes.COUPE),
            new SportsCar(Colors.WHITE, Models.MERCEDES, WheelSize.FOURTEEN, EngineVolumes.REGULAR,
                    new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING)), RacingTypes.DRIFT,
                    PassengerCarTypes.COUPE)));

    public SportsCarFactory(ChangeColorService changeColorService, ChangeWheelsService changeWheelsService,
                            RemoveCarOptionsService removeCarOptionsService, AddCarOptionsService addCarOptionsService,
                            StorageImpl sportCarsStorage) {
        super(changeColorService, changeWheelsService, removeCarOptionsService, addCarOptionsService);
        this.sportsCarStorage = sportCarsStorage;
        sportCarsStorage.addToStorage(listOfFactoryCars);
    }

    @Override
    public void printFactoryCarParameters() {
        super.printFactoryCarParameters();
        System.out.println("Racing types are: " + racingTypes);
        System.out.println("Passenger types are: " + passengerCarTypes);
    }

    @Override
    public ArrayList<SportsCar> checkUnchangeableParameters(Models model, EngineVolumes engineVolume) {

        for (SportsCar storageCar : sportsCarStorage.getCarsStorageList()) {
            if (storageCar.getModel().equals(model) &&
                    storageCar.getEngineVolume() == engineVolume) {
                listOfFactoryCandidateCars.add(storageCar);
            }
        }
        return listOfFactoryCandidateCars;
    }

    public SportsCar createSportsCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                                     HashSet<CarOptions> carOptionsList, RacingTypes racingTypes,
                                     PassengerCarTypes passengerCarTypes) {
        SportsCar car = null;
        if (!(sportsCarStorage.getCarsStorageList().size() == 0)) {
            checkUnchangeableParameters(model, engineVolume);
        } else {
            return new SportsCar(color, model, wheelSize, engineVolume, carOptionsList, racingTypes, passengerCarTypes);
        }
        if (!(listOfFactoryCandidateCars.isEmpty())) {
            car =  searchForMostSuitableFactoryCar(color, wheelSize, carOptionsList);
            if (car == null) {
                car = (SportsCar) sportsCarStorage.getFromStorage();
                changeColor(car, color);
                changeWheelSize(car, wheelSize);
                setCarOptions(car, carOptionsList);
                return (SportsCar) car;
            } else {
                sportsCarStorage.getFromStorage();
                setCarParameters(car, color, wheelSize, carOptionsList);
            }
        } else{
            car = new SportsCar(color, model, wheelSize, engineVolume, carOptionsList, racingTypes, passengerCarTypes);
        }
        return (SportsCar) car;

}
    @Override
    public SportsCar searchForMostSuitableFactoryCar(Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptionsList) {
        SportsCar car = null;
        for (Car storageCar :  listOfFactoryCandidateCars) {
            if (storageCar.getColor().equals(color) && storageCar.getWheelSize() == wheelSize &&
                    storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (SportsCar) storageCar;
                sportsCarStorage.removeFromStorage((SportsCar) storageCar);
                return car;
            }
        }
        for (Car storageCar :  listOfFactoryCandidateCars) {
            if ((!(storageCar.getColor().equals(color)) && (storageCar.getWheelSize() == wheelSize) &&
                    storageCar.getCarOptionsList().equals(carOptionsList)) || (storageCar.getColor().equals(color)
                    && storageCar.getCarOptionsList().equals(carOptionsList) && (storageCar.getWheelSize() != wheelSize))) {
                car = (SportsCar) storageCar;
            }
            else if (!(storageCar.getColor().equals(color)) && storageCar.getWheelSize() == wheelSize &&
                    !(storageCar.getCarOptionsList().equals(carOptionsList)) || storageCar.getColor().equals(color) &&
                    storageCar.getWheelSize() != wheelSize && storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (SportsCar) storageCar;
            }
            else if (storageCar.getColor().equals(color) && storageCar.getWheelSize() != wheelSize &&
                    !(storageCar.getCarOptionsList().equals(carOptionsList)) || !(storageCar.getColor().equals(color)) &&
                    storageCar.getWheelSize() != wheelSize && storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (SportsCar) storageCar;
            }
        }
        sportsCarStorage.removeFromStorage(car);
        return car;
    }

    public RacingTypes getRacingTypes() {
        return racingTypes;
    }

    @Override
    public void setCarParameters(Car car, Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptions) {
        super.setCarParameters(car, color, wheelSize, carOptions);
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

    public ArrayList<?> getListOfFactoryCandidateCars() {
        return listOfFactoryCandidateCars;
    }

    public StorageImpl getSportCarsStorage() {
        return sportsCarStorage;
    }

    public List<SportsCar> getListOfFactoryCars() {
        return listOfFactoryCars;
    }
}
