package Homework6;

import java.util.*;

public class Country1 implements Runnable{

    int counter = 0;
    private List<Robot> robotParts = new ArrayList<>();
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

    public boolean compareLists(List<Robot> robotParts, List<Robot> robotEnumList){
        for(int i = 0; i < robotEnumList.size(); i++){
            if(robotEnumList.get(i) != robotParts.get(i)){
                return false;
            }
        }
        return true;
    }

    public void consume() throws InterruptedException {
            while (consumer) {
                synchronized (factory.BUFFER) {
                    orderRobotParts(factory.producedPart);
                    System.out.println("Country1 consumed: " + factory.producedPart);
                    removeFromBuffer(factory.producedPart);
                    if (compareLists(robotParts, robotEnumList)) {
                        counter++;
                        System.out.println(counter);
                        robotParts.removeAll(List.of(Robot.values()));
                    }
                    Thread.sleep(500);
                    if (counter == 20) {
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
