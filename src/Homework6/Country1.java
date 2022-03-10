package Homework6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Country1 implements Runnable{

    int counter = 0;
    private Set<Robot> robotParts = new HashSet<>();
    private List<Robot> robotEnumList = new ArrayList<>();
    Factory factory;
    private static volatile boolean consumer = true;

    public Country1(Factory factory) {
        this.factory = factory;
        addRobotEnumListValues();
    }

    public List<Robot> addRobotEnumListValues() {
        robotEnumList.addAll(List.of(Robot.values()));
        return robotEnumList;
    }

    public void orderRobotParts(Robot factoryRobotPart) {
            if (!(robotParts.contains(factoryRobotPart)) && !(factory.BUFFER.isEmpty())) {
                robotParts.add(factoryRobotPart);
            }
    }

    public void removeFromBuffer(Robot factoryRobotPart) {
        synchronized (factory.BUFFER) {
            factory.BUFFER.remove(factoryRobotPart);
        }
    }

    public void consume() throws InterruptedException {
            while (consumer) {
                synchronized (factory.BUFFER) {
                    orderRobotParts(factory.producedPart);
                    System.out.println("Country1 consumed: " + factory.producedPart);
                    removeFromBuffer(factory.producedPart);
                    if (robotParts.containsAll(robotEnumList)) {
                        counter++;
                        System.out.println(counter);
                        robotParts.removeAll(robotEnumList);
                    }
                    Thread.sleep(500);
                    if (counter == 5) {
                        consumer = false;
                        System.out.println("Country1 has won");
                    }
                }
            }
        }

    @Override
    public void run() {
        while (consumer) {
            try {
                consume();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                consumer = false;
            }
        }
    }
}
