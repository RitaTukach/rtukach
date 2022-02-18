package Homework3;

public interface Service {

    void setColor(Car car, AutoFactory.Colors color);

    void setWheelSize(Car car, int wheelSize);

    void setCarOptions(Car car, AutoFactory.CarOptions carOptions);
}
