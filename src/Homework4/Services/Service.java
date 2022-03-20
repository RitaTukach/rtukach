package Homework4.Services;


import Homework4.Cars.Car;

public interface Service<T> {

        void doService(Car car, T value);
}

