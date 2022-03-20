package Homework4.Storages;

import Homework4.Cars.Car;

import java.util.List;

public interface Storage<T extends Car> {

        void addToStorage(List<T> elements);

        void removeFromStorage(T car);

        T getFromStorage();
}
