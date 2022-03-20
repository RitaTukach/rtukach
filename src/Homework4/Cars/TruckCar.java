package Homework4.Cars;

import Homework4.Parameters.*;
import Homework4.Parameters.CargoTypes;
import java.util.HashSet;
import java.util.Set;


public class TruckCar extends Car {

    private CargoTypes cargoType;

    public TruckCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume, RacingTypes racingType,
                     PassengerCarTypes passengerCarTypes) {
        super(color, model, wheelSize, engineVolume);
        this.cargoType = cargoType;
    }

    public TruckCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                    HashSet<CarOptions> carOptionsList, CargoTypes cargoType) {
        super(color, model, wheelSize, engineVolume);
        this.cargoType = cargoType;
        carOptionsList = new HashSet<>(Set.of(CarOptions.values()));

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
