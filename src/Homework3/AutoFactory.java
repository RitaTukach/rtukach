package Homework3;

import java.util.*;

public class AutoFactory{

    private final int year = 2021;
    private ArrayList<Car> listOfFactoryCandidateCars = new ArrayList<>();
    private List<Models> modelsList = Arrays.asList(Models.values());
    private List<Colors> colorsList = Arrays.asList(Colors.values());
    private List<EngineVolumes> enginesVolumeList = Arrays.asList(EngineVolumes.values());;
    private List<WheelSize> wheelsSizeList = Arrays.asList(WheelSize.values());
    HashSet<CarOptions> carOptionsList = new HashSet<>(Set.of(CarOptions.values()));
    private HashSet<Car> listOfFactoryCars  = new HashSet<>(Set.of());

    public AutoFactory () {
        Collections.addAll(carOptionsList, CarOptions.BLUETOOTH, CarOptions.CAMERA, CarOptions.WHEEL_HEATING);
        printFactoryCarParameters();
        createAutofactoryCars(listOfFactoryCars);
    }

    public void printFactoryCarParameters() {
        System.out.println("Factory models: " + modelsList);
        System.out.println("Factory engine volumes: " + enginesVolumeList);
        System.out.println("Factory colors: " + colorsList);
        System.out.println("Factory wheels size: " + wheelsSizeList);
    }

    private  HashSet<Car> createAutofactoryCars(HashSet<Car> listOfFactoryCars) {
        Car car1 = new Car(Colors.YELLOW, Models.MERCEDES, year, WheelSize.FIFTEEN, EngineVolumes.RACING, carOptionsList);
        Car car2 = new Car(Colors.WHITE, Models.MERCEDES, year, WheelSize.FOURTEEN, EngineVolumes.REGULAR, new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING)));
        Car car3 = new Car(Colors.GRAY, Models.MERCEDES, year, WheelSize.SEVENTEEN, EngineVolumes.RACING, new HashSet<>(Set.of(CarOptions.BLUETOOTH)));
        Collections.addAll(listOfFactoryCars, car1, car2, car3);
        return listOfFactoryCars;
    }

    private ArrayList<Car> checkUnchangeableParameters(Models model, int year, EngineVolumes engineVolume) {
        for (Car autofactoryCar : listOfFactoryCars) {
            if (autofactoryCar.getModel().equals(model) && autofactoryCar.getYear() == year &&
                    autofactoryCar.getEngineVolume() == engineVolume) {
                listOfFactoryCandidateCars.add(autofactoryCar);
            }
        }
        return listOfFactoryCandidateCars;
    }

    private Car searchForMostSuitableFactoryCar(Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptionsList) {
        Car car = null;
        for (Car autofactoryCar :  listOfFactoryCandidateCars) {
            if (autofactoryCar.getColor().equals(color) && autofactoryCar.getWheelSize() == wheelSize &&
                    autofactoryCar.getCarOptionsList().equals(carOptionsList)) {
                car = autofactoryCar;
                listOfFactoryCars.remove(autofactoryCar);
                return car;
            }
        }
        for (Car autofactoryCar :  listOfFactoryCandidateCars) {
            if (!(autofactoryCar.getColor().equals(color)) && autofactoryCar.getWheelSize() == wheelSize &&
                    autofactoryCar.getCarOptionsList().equals(carOptionsList) || autofactoryCar.getColor().equals(color)
                    && autofactoryCar.getCarOptionsList().equals(carOptionsList) && autofactoryCar.getWheelSize() != wheelSize) {
                car = autofactoryCar;
            }
            else if (!(autofactoryCar.getColor().equals(color)) && autofactoryCar.getWheelSize() == wheelSize &&
                    !(autofactoryCar.getCarOptionsList().equals(carOptionsList)) || autofactoryCar.getColor().equals(color) &&
                    autofactoryCar.getWheelSize() != wheelSize && autofactoryCar.getCarOptionsList().equals(carOptionsList)) {
                car = autofactoryCar;
            }
            else if (autofactoryCar.getColor().equals(color) && autofactoryCar.getWheelSize() != wheelSize &&
                    !(autofactoryCar.getCarOptionsList().equals(carOptionsList)) || !(autofactoryCar.getColor().equals(color)) &&
                    autofactoryCar.getWheelSize() != wheelSize && autofactoryCar.getCarOptionsList().equals(carOptionsList)) {
                car = autofactoryCar;
            }
        }
        return car;
    }

    public void setCarParameters(Car car, Colors color, WheelSize wheelSize, HashSet<CarOptions> carOptions) {
        if (!(car.getColor().equals(color))) {
            setColor(car, color);
        }
        if (car.getWheelSize() != wheelSize) {
            setWheelSize(car, wheelSize);
        }
        if (!(car.getCarOptionsList().equals(carOptions))) {
            setCarOptions(car, carOptions);
        }
    }

    public Car createCar(Colors color, Models model, int year, WheelSize wheelSize, EngineVolumes engineVolume, HashSet<CarOptions> carOptionsList) {
       Car car = null;
        checkUnchangeableParameters(model, year, engineVolume);
        if (!(listOfFactoryCandidateCars.isEmpty())) {
            car = searchForMostSuitableFactoryCar(color, wheelSize, carOptionsList);
            if (car == null) {
                car = listOfFactoryCandidateCars.get(0);
                removeCarFromStorage(car);
                setColor(car, color);
                setWheelSize(car, wheelSize);
                setCarOptions(car, carOptionsList);
                return car;
            } else {
                removeCarFromStorage(car);
                setCarParameters(car, color, wheelSize, carOptionsList);
            }
        } else{
                car = new Car(color, model, year, wheelSize, engineVolume, carOptionsList);
            }
            return car;
        }

    private HashSet<Car> removeCarFromStorage(Car car) {
        listOfFactoryCars.remove(car);
        return listOfFactoryCars;
    }

    public void changeColor(Service service, Car car, Colors color) {
        service.changeColor(car, color);
    }

    public void setColor(Car car, Colors color) {
        car.setColor(color);
    }

    public void changeWheelSize(Service service, Car car, WheelSize wheelSize) {
        car.setWheelSize(wheelSize);
    }

    public void setWheelSize(Car car, WheelSize wheelSize) {
        car.setWheelSize(wheelSize);

    }

    public void AddCarOptions(Service service, Car car, CarOptions carOption) {
        service.addCarOptions(car, carOption);
    }

    public void removeCarOptions(Service service, Car car, CarOptions carOption) {
        service.removeCarOptions(car, carOption);
    }

    public void setCarOptions(Car car, HashSet<CarOptions> carOptionsList) {
        car.setCarOptionsList(carOptionsList);
    }
}
