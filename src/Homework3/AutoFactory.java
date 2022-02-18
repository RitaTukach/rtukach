package Homework3;

import java.util.*;

public class AutoFactory implements Service{

    private HashSet<Car> listOfFactoryCars = new LinkedHashSet<>();
    private ArrayList<Car> listOfFactoryCandidateCars = new ArrayList<>();
    public static Double[] enginesVolumeList = {1.4, 1.6, 1.8, 2.0, 2.5, 3.0};
    public static int[] wheelsSizeList = {14, 15, 16, 17, 18};

    public AutoFactory () {
       createAutofactoryCars();
    }

    public void printFactoryCarParameters() {
        System.out.println("Factory models: " + Arrays.toString(Models.values()));
        System.out.println("Factory engine volumes: " + Arrays.toString(enginesVolumeList));
        System.out.println("Factory colors: " + Arrays.toString(Colors.values()));
        System.out.println("Factory wheels size: " + Arrays.toString(wheelsSizeList));
    }

    private  void createAutofactoryCars() {
        HashSet<CarOptions> carOptionsList = new HashSet<>();
        Collections.addAll(carOptionsList, CarOptions.BLUETOOTH, CarOptions.CAMERA, CarOptions.WHEEL_HEATING);
        Car car1 = new Car(Colors.YELLOW, Models.MERCEDES, 2020, 15, 2.5, carOptionsList);
        Car car2 = new Car(Colors.WHITE, Models.MERCEDES, 2021, 184, 2.5, new HashSet<>(Set.of(CarOptions.BLUETOOTH, CarOptions.WHEEL_HEATING)));
        Car car3 = new Car(Colors.GRAY, Models.MERCEDES, 2021, 16, 2.5, new HashSet<>(Set.of(CarOptions.BLUETOOTH)));
        Collections.addAll(listOfFactoryCars, car1, car2, car3);
    }

    private ArrayList<Car> checkUnchangeableParameters(Models model, int year, double engineVolume) {
        for (Car autofactoryCar : listOfFactoryCars) {
            if (autofactoryCar.getModel().equals(model) && autofactoryCar.getYear() == year &&
                    autofactoryCar.getEngineVolume() == engineVolume) {
                listOfFactoryCandidateCars.add(autofactoryCar);
            }
        }
        return listOfFactoryCandidateCars;
    }

    private Car searchForMostSuitableFactoryCar(Colors color, int wheelSize, HashSet<CarOptions> carOptionsList) {
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

    public void setCarParameters(Car car, Colors color, int wheelSize, HashSet<CarOptions> carOptions) {
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

    public Car createCar(Colors color, Models model, int year, int wheelSize, double engineVolume, HashSet<CarOptions> carOptionsList) {
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

    @Override
    public void setColor(Car car, Colors color) {
        car.setColor(color);
    }

    @Override
    public void setWheelSize(Car car, int wheelSize) {
        car.setWheelSize(wheelSize);
    }

    @Override
    public void setCarOptions(Car car, HashSet<CarOptions> carOptionsList) {
        car.setCarOptionsList(carOptionsList);
    }
}
