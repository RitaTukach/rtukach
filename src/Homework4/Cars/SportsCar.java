package Homework4.Cars;
import Homework4.Parameters.*;
import Homework4.Parameters.RacingTypes;
import java.util.HashSet;
import java.util.Set;

public class SportsCar extends Car {

    private RacingTypes racingType;
    private PassengerCarTypes passengerCarTypes;

    public SportsCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume, RacingTypes racingType,
                     PassengerCarTypes passengerCarTypes) {
        super(color, model, wheelSize, engineVolume);
        this.racingType = racingType;
        this.passengerCarTypes = passengerCarTypes;
    }

    public SportsCar(Colors color, Models model, WheelSize wheelSize, EngineVolumes engineVolume,
                     HashSet<CarOptions> carOptionsList, RacingTypes racingType,
                     PassengerCarTypes passengerCarTypes) {
        super(color, model, wheelSize, engineVolume);
        this.racingType = racingType;
        this.passengerCarTypes = passengerCarTypes;
        carOptionsList = new HashSet<>(Set.of(CarOptions.values()));

        if (!carOptionsList.isEmpty()) {
            setCarOptionsList(carOptionsList);
        }
    }

    public RacingTypes getRacingType() {
        return racingType;
    }

    public PassengerCarTypes getPassengerCarTypes() {
        return passengerCarTypes;
    }

    public void setRacingType(RacingTypes racingType) {
        this.racingType = racingType;
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
                "SportsCar{" +
                "racingType=" + racingType +
                ", type=" + passengerCarTypes +
                '}';
    }

    @Override
    public void printCarInfo() {
        super.printCarInfo();
        this.toString();
    }
}
