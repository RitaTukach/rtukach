package Homework4.Factories;
import Homework4.Services.AddCarOptionsService;
import Homework4.Cars.Car;
import Homework4.Services.ChangeColorService;
import Homework4.Services.ChangeWheelsService;
import Homework4.Parameters.*;
import Homework4.Services.RemoveCarOptionsService;
import java.util.*;

public abstract class AutoFactory<T> {

    public final static int year = 2021;
    private ArrayList<Car> listOfFactoryCandidateCars = new ArrayList<>();
    private List<Models> modelsList = Arrays.asList(Models.values());
    private List<Colors> colorsList = Arrays.asList(Colors.values());
    private List<EngineVolumes> enginesVolumeList = Arrays.asList(EngineVolumes.values());;
    private List<WheelSize> wheelsSizeList = Arrays.asList(WheelSize.values());
    private HashSet<CarOptions> carOptionsList = new HashSet<>(Set.of(CarOptions.values()));
    private ChangeColorService changeColorService;
    private ChangeWheelsService changeWheelsService;
    private RemoveCarOptionsService removeCarOptionsService;
    private AddCarOptionsService addCarOptionsService;
    private RacingTypes racingTypes;
    private PassengerCarTypes passengerCarTypes;
    private CargoTypes cargoTypes;
    private SportsCarFactory sportsCarFactory;
    private PassengerCarFactory passengerCarFactory;
    private TruckCarFactory truckCarFactory;

    public AutoFactory(ChangeColorService changeColorService, ChangeWheelsService changeWheelsService,
                       RemoveCarOptionsService removeCarOptionsService, AddCarOptionsService addCarOptionsService) {
        this.changeColorService = changeColorService;
        this.changeWheelsService = changeWheelsService;
        this.removeCarOptionsService= removeCarOptionsService;
        this.addCarOptionsService = addCarOptionsService;
        Collections.addAll(carOptionsList, CarOptions.BLUETOOTH, CarOptions.CAMERA, CarOptions.WHEEL_HEATING);
    }

    public void printFactoryCarParameters() {
        System.out.println("Factory models: " + modelsList);
        System.out.println("Factory engine volumes: " + enginesVolumeList);
        System.out.println("Factory colors: " + colorsList);
        System.out.println("Factory wheels size: " + wheelsSizeList);
    }

    public Car createCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                         HashSet<CarOptions> carOptionsList, T... ts) {
        Car car = null;
        for (CargoTypes type: CargoTypes.values()) {
            if (ts[0].equals(type)) {
                car = truckCarFactory.createTruckCar(color, model, wheelSize, engineVolume, carOptionsList, cargoTypes);
            }
        }
        for (RacingTypes type: RacingTypes.values()) {
            if (ts[0].equals(type)) {
                car = sportsCarFactory.createSportsCar(color, model, wheelSize, engineVolume, carOptionsList,
                        racingTypes, passengerCarTypes);
            }
        }
        for (PassengerCarTypes type: PassengerCarTypes.values()) {
            if (ts[0].equals(type)) {
                car = passengerCarFactory.createPassengerCar(color, model, wheelSize, engineVolume, carOptionsList,
                        passengerCarTypes);
            }
        }
        return car;
    }

    public abstract ArrayList<?> checkUnchangeableParameters(Models model, EngineVolumes engineVolume);

    public abstract Car searchForMostSuitableFactoryCar(Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptionsList);

    public void setCarParameters(Car car, Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptions) {
        if (!(car.getColor().equals(color))) {
            changeColor(car, color);
        }
        if (car.getWheelSize() != wheelSize) {
            changeWheelSize(car, wheelSize);
        }
        if (!(car.getCarOptionsList().equals(carOptions))) {
            setCarOptions(car, carOptions);
        }
    }

    public void setCarOptionsList(HashSet<CarOptions> carOptionsList) {
        this.carOptionsList = carOptionsList;
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

    public void setCarOptions(Car car, HashSet<CarOptions> carOptionsList) {
            setCarOptionsList(carOptionsList);
    }
}
