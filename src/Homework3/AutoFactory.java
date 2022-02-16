package Homework3;

import java.util.*;

public class AutoFactory implements Service{

    HashSet<Car> listOfFactoryCars = new LinkedHashSet<>();
    ArrayList<Car> listOfFactoryCandidateCars = new ArrayList<>();

    public enum Models {
        MERCEDES,
        OPEL,
        BMW,
        AUDI,
        NISSAN
        ;
    }
    public static Double[] enginesVolumeList = {1.4, 1.6, 1.8, 2.0, 2.5, 3.0};

    public enum Colors {
        YELLOW("yellow"),
        WHITE("white"),
        BLACK("black"),
        GRAY("gray"),
        RED("red")
        ;
        String colorName;
        Colors(String colorName){
            this.colorName = colorName;
        }
    }
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
        Car car1 = new Car(Colors.YELLOW, AutoFactory.Models.MERCEDES, 2020, 14, 2.5);
        Car car2 = new Car(Colors.WHITE, AutoFactory.Models.MERCEDES, 2021, 18, 2.5);
        Car car3 = new Car(Colors.GRAY, AutoFactory.Models.MERCEDES, 2021, 12, 2.5);
        Collections.addAll(listOfFactoryCars, car1, car2, car3);
    }

    private ArrayList<Car> checkUnchangeableParameters(Models model, int year, double engineVolume) {
        for (Car autofactoryCar : listOfFactoryCars) {
            if (autofactoryCar.getModel().equals(model) && autofactoryCar.getYear() == year && autofactoryCar.getEngineVolume() == engineVolume) {
                listOfFactoryCandidateCars.add(autofactoryCar);
            }
        }
        return listOfFactoryCandidateCars;
    }

    private Car searchForMostSuitableFactoryCar(Colors color, int wheelSize) {
        Car car = null;
        for (Car autofactoryCar :  listOfFactoryCandidateCars) {
            if (autofactoryCar.getColor().equals(color) && autofactoryCar.getWheelSize() == wheelSize) {
                car = autofactoryCar;
                listOfFactoryCars.remove(autofactoryCar);
                return car;
            }
        }
        for (Car autofactoryCar :  listOfFactoryCandidateCars) {
            if (!(autofactoryCar.getColor().equals(color)) && autofactoryCar.getWheelSize() == wheelSize ||
                    autofactoryCar.getColor().equals(color)  && autofactoryCar.getWheelSize() != wheelSize) {
                car = autofactoryCar;
            }
        }
        return car;
    }

    public Car createCar(Colors color, Models model, int year, int wheelSize, double engineVolume) {
        Car car = null;
        checkUnchangeableParameters(model, year, engineVolume);
        if (!(listOfFactoryCandidateCars.isEmpty())) {
           car = searchForMostSuitableFactoryCar(color, wheelSize);
            if (car == null) {
                car = listOfFactoryCandidateCars.get(0);
                listOfFactoryCars.remove(listOfFactoryCandidateCars.get(0));
                car.setColor(color);
                car.setWheelSize(wheelSize);
            }
            else if (car.getColor().equals(color) && car.getWheelSize() == wheelSize) {
                return car;
            }
            else if (car.getWheelSize() != wheelSize) {
                car.setWheelSize(wheelSize);
            } else {
                car.setColor(color);
            }
        } else {
            car = new Car(color, model, year, wheelSize, engineVolume);
        }
        return car;
    }

    @Override
    public void setColor(Colors color) {

    }

    @Override
    public void setWheelSize(int wheelSize) {

    }

    @Override
    public void setList(List<String> list) {

    }

}
