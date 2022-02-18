package Homework3;

import java.util.*;
import Homework3.Models;
import Homework3.Colors;

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
        Car car1 = new Car(Colors.YELLOW, Models.MERCEDES, 2020, 15, 2.5, CarOptions.BLUETOOTH);
        Car car2 = new Car(Colors.WHITE, Models.MERCEDES, 2021, 17, 2.5, CarOptions.CAMERA);
        Car car3 = new Car(Colors.GRAY, Models.MERCEDES, 2021, 16, 2.5, CarOptions.NO_OPTION);
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

    private Car searchForMostSuitableFactoryCar(Colors color, int wheelSize, CarOptions carOptions) {
        Car car = null;
        for (Car autofactoryCar :  listOfFactoryCandidateCars) {
            if (autofactoryCar.getColor().equals(color) && autofactoryCar.getWheelSize() == wheelSize &&
                    autofactoryCar.getCarOptions().equals(carOptions)) {
                car = autofactoryCar;
                listOfFactoryCars.remove(autofactoryCar);
                return car;
            }
        }
        for (Car autofactoryCar :  listOfFactoryCandidateCars) {
            if (!(autofactoryCar.getColor().equals(color)) && autofactoryCar.getWheelSize() == wheelSize &&
                    autofactoryCar.getCarOptions().equals(carOptions) || autofactoryCar.getColor().equals(color)
                    && autofactoryCar.getCarOptions().equals(carOptions) && autofactoryCar.getWheelSize() != wheelSize) {
                car = autofactoryCar;
            }
            else if (!(autofactoryCar.getColor().equals(color)) && autofactoryCar.getWheelSize() == wheelSize &&
                    !(autofactoryCar.getCarOptions().equals(carOptions)) || autofactoryCar.getColor().equals(color) &&
                    autofactoryCar.getWheelSize() != wheelSize && autofactoryCar.getCarOptions().equals(carOptions)) {
                car = autofactoryCar;
            }
            else if (autofactoryCar.getColor().equals(color) && autofactoryCar.getWheelSize() != wheelSize &&
                    !(autofactoryCar.getCarOptions().equals(carOptions)) || !(autofactoryCar.getColor().equals(color)) &&
                    autofactoryCar.getWheelSize() != wheelSize && autofactoryCar.getCarOptions().equals(carOptions)) {
                car = autofactoryCar;
            }
        }
        return car;
    }

    public void setCarParameters(Car car, Colors color, int wheelSize, CarOptions carOptions) {
        if (!(car.getColor().equals(color))) {
            setColor(car, color);
        }
        if (car.getWheelSize() != wheelSize) {
            setWheelSize(car, wheelSize);
        }
        if (!(car.getCarOptions().equals(carOptions))) {
            setCarOptions(car, carOptions);
        }
    }

    public Car createCar(Colors color, Models model, int year, int wheelSize, double engineVolume, CarOptions carOptions) {
        Car car = null;
        checkUnchangeableParameters(model, year, engineVolume);
        if (!(listOfFactoryCandidateCars.isEmpty())) {
            car = searchForMostSuitableFactoryCar(color, wheelSize, carOptions);
            if (car == null) {
                car = listOfFactoryCandidateCars.get(0);
                removeCarFromStorage(car);
                setColor(car, color);
                setWheelSize(car, wheelSize);
                setCarOptions(car, carOptions);
                return car;
            } else {
                removeCarFromStorage(car);
                setCarParameters(car, color, wheelSize, carOptions);
            }
        } else{
                car = new Car(color, model, year, wheelSize, engineVolume, carOptions);
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
    public void setCarOptions(Car car, CarOptions carOptions) {
        car.setCarOptions(carOptions);
    }
}
