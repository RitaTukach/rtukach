package Homework6;

import java.util.ArrayList;
import java.util.List;

public class Country2 implements Runnable{

    int counter = 0;
    private List<Robot> robotParts = new ArrayList<>();
    private List<Robot> robotEnumList = new ArrayList<>();
    Factory factory;
    private static volatile boolean consumer = true;

    public Country2(Factory factory) {
        this.factory = factory;
        addRobotEnumListValues();
    }

    public List<Robot> addRobotEnumListValues() {
        robotEnumList.addAll(List.of(Robot.values()));
        return robotEnumList;
    }

    public boolean compareLists(List<Robot> robotParts, List<Robot> robotEnumList){
        for(int i = 0; i < robotParts.size(); i++){
            if(robotEnumList.get(i) != robotParts.get(i)){
                return false;
            }
        }
        return true;
    }

    public void orderRobotParts(Robot factoryRobotPart) {
            if (!(robotParts.contains(factoryRobotPart)) && !(factory.BUFFER.isEmpty())) {
                robotParts.add(factoryRobotPart);
            }
    }

    public void consume() throws InterruptedException {
        while (consumer) {
            synchronized (factory.BUFFER) {
                orderRobotParts(factory.producedPart);
                System.out.println("Country2 consumed: " + factory.producedPart);
                factory.BUFFER.remove(factory.producedPart);
                if (compareLists(robotParts, robotEnumList)) {
                    counter++;
                    System.out.println(counter);
                    robotParts.removeAll(List.of(Robot.values()));
                }
                     Thread.sleep(500);
                if (counter == 20) {
                    consumer = false;
                    System.out.println("Country2 has won");
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

