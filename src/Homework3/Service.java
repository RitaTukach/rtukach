package Homework3;

import java.util.HashSet;

public interface Service {

    void setColor(Car car, Colors color);

    void setWheelSize(Car car, int wheelSize);

    void setCarOptions(Car car, HashSet<CarOptions> carOptionsList);
}
