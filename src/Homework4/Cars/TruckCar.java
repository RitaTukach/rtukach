package Homework4.Cars;

import Homework4.Parameters.*;
import Homework4.Parameters.CargoTypes;
import java.util.HashSet;


public class TruckCar extends Car {

    private CargoTypes cargoType;

    public TruckCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                    HashSet<CarOptions> carOptionsList, CargoTypes cargoType) {
        super(color, model, wheelSize, engineVolume);
        this.cargoType = cargoType;
        if (!(carOptionsList.isEmpty())) {
            setCarOptionsList(carOptionsList);
        }
    }

    public CargoTypes getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoTypes cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "TruckCar{" +
                "cargoType=" + cargoType +
                '}';
    }
}
