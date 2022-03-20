package Homework4.Storages;

import Homework4.Cars.Car;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl<T extends Car> implements Storage<T> {

    private final List<T> carsStorageList = new ArrayList<>();

    @Override
    public void addToStorage(List<T> elements) {
            synchronized (carsStorageList) {
                carsStorageList.addAll(elements);
            }
    }

    @Override
    public void removeFromStorage(T car) {
        if (carsStorageList.contains(car)) {
            carsStorageList.remove(car);
        }
    }

    @Override
    public T getFromStorage() {
        {
            synchronized (carsStorageList) {
                if (!carsStorageList.isEmpty()) {
                    return carsStorageList.remove(0);
                }
            }
            return null;
        }
    }

    public List<T> getCarsStorageList() {
        return carsStorageList;
    }
}
