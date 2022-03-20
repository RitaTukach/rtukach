package Homework4.Factories;

import Homework4.Cars.Car;
import Homework4.Cars.TruckCar;
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

public class TruckCarFactory<T> extends AutoFactory<T>  {

    private ArrayList<TruckCar> listOfFactoryCandidateCars = new ArrayList<>();
    private CargoTypes cargoTypes;
    public StorageImpl<TruckCar> truckCarStorage = new StorageImpl<>();

    private final List<TruckCar> listOfFactoryCars = new ArrayList<>(Set.of(
            new TruckCar(Colors.YELLOW, Models.MERCEDES, WheelSize.FIFTEEN, EngineVolumes.RACING, null, CargoTypes.PICKUP),
            new TruckCar(Colors.WHITE, Models.MERCEDES, WheelSize.FOURTEEN, EngineVolumes.REGULAR,
                    new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING)), CargoTypes.CAR_TRANSPORTER),
            new TruckCar(Colors.WHITE, Models.MERCEDES, WheelSize.FOURTEEN, EngineVolumes.REGULAR,
                    new HashSet<>(Set.of(CarOptions.BLUETOOTH)), CargoTypes.TANKER)));

    public TruckCarFactory(ChangeColorService changeColorService, ChangeWheelsService changeWheelsService,
                           RemoveCarOptionsService removeCarOptionsService, AddCarOptionsService addCarOptionsService) {
        super(changeColorService, changeWheelsService, removeCarOptionsService, addCarOptionsService);
        this.truckCarStorage = truckCarStorage;
        truckCarStorage.addToStorage(listOfFactoryCars);
    }

    @Override
    public void printFactoryCarParameters() {
        super.printFactoryCarParameters();
        System.out.println("Cargo Types types are: " + cargoTypes);
    }

    @Override
    public ArrayList<TruckCar> checkUnchangeableParameters(Models model, EngineVolumes engineVolume) {
        for (TruckCar storageCar : truckCarStorage.getCarsStorageList()) {
            if (storageCar.getModel().equals(model) &&
                    storageCar.getEngineVolume() == engineVolume) {
                listOfFactoryCandidateCars.add(storageCar);
            }
        }
        return listOfFactoryCandidateCars;
    }

    public TruckCar createTruckCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                                     HashSet<CarOptions> carOptionsList, CargoTypes cargoTypes) {
        TruckCar car = null;
        if (!(truckCarStorage.getCarsStorageList().size() == 0)) {
            checkUnchangeableParameters(model, engineVolume);
        } else {
            return new TruckCar(color, model, wheelSize, engineVolume, carOptionsList, cargoTypes);
        }
        if (!(listOfFactoryCandidateCars.isEmpty())) {
            car = searchForMostSuitableFactoryCar(color, wheelSize, carOptionsList);
            if (car == null) {
                car = (TruckCar) truckCarStorage.getFromStorage();
                changeColor(car, color);
                changeWheelSize(car, wheelSize);
                setCarOptions(car, carOptionsList);
                return (TruckCar) car;
            } else {
                truckCarStorage.getFromStorage();
                setCarParameters(car, color, wheelSize, carOptionsList);
            }
        } else {
            car = new TruckCar(color, model, wheelSize, engineVolume, carOptionsList, cargoTypes);
        }
        return (TruckCar) car;
    }

    @Override
    public TruckCar searchForMostSuitableFactoryCar(Colors color, WheelSize wheelSize, HashSet carOptionsList) {
        TruckCar car = null;
        for (Car storageCar :  listOfFactoryCandidateCars) {
            if (storageCar.getColor().equals(color) && storageCar.getWheelSize() == wheelSize &&
                    storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (TruckCar) storageCar;
                truckCarStorage.removeFromStorage((TruckCar) storageCar);
                return car;
            }
        }
        for (Car storageCar :  listOfFactoryCandidateCars) {
            if ((!(storageCar.getColor().equals(color)) && (storageCar.getWheelSize() == wheelSize) &&
                    storageCar.getCarOptionsList().equals(carOptionsList)) || (storageCar.getColor().equals(color)
                    && storageCar.getCarOptionsList().equals(carOptionsList) && (storageCar.getWheelSize() != wheelSize))) {
                car = (TruckCar) storageCar;
            }
            else if (!(storageCar.getColor().equals(color)) && storageCar.getWheelSize() == wheelSize &&
                    !(storageCar.getCarOptionsList().equals(carOptionsList)) || storageCar.getColor().equals(color) &&
                    storageCar.getWheelSize() != wheelSize && storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (TruckCar) storageCar;
            }
            else if (storageCar.getColor().equals(color) && storageCar.getWheelSize() != wheelSize &&
                    !(storageCar.getCarOptionsList().equals(carOptionsList)) || !(storageCar.getColor().equals(color)) &&
                    storageCar.getWheelSize() != wheelSize && storageCar.getCarOptionsList().equals(carOptionsList)) {
                car = (TruckCar) storageCar;
            }
        }
        truckCarStorage.removeFromStorage(car);
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
