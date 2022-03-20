package Homework4.Cars;

import Homework4.Parameters.*;
import java.util.HashSet;
import java.util.Set;

public class PassengerCar extends Car {

    private PassengerCarTypes passengerCarTypes;

    public PassengerCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume, PassengerCarTypes type) {
        super(color, model, wheelSize, engineVolume);
        this.passengerCarTypes = type;
    }

    public PassengerCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                        HashSet<CarOptions> carOptionsList, PassengerCarTypes type) {
        super(color, model, wheelSize, engineVolume);
        this.passengerCarTypes = type;
        carOptionsList = new HashSet<>(Set.of(CarOptions.values()));

        if (!carOptionsList.isEmpty()) {
            setCarOptionsList(carOptionsList);
        }
    }

    public PassengerCarTypes getType() {
        return passengerCarTypes;
    }

    public void setType(PassengerCarTypes type) {
        this.passengerCarTypes = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "PassengerCar{" +
                "type=" + passengerCarTypes +
                '}';
    }
}
