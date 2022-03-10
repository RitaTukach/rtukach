package Homework6;

import java.util.LinkedList;
import java.util.Random;

public class Factory  {

    Random RANDOM = new Random();
    public LinkedList<Robot> BUFFER = new LinkedList<>();
    private static volatile boolean producer = true;
    Robot producedPart;

    public void produceRobotPart()  {
            while (producer) {
                synchronized (BUFFER) {
                    producedPart = Robot.values()[RANDOM.nextInt(0, 5)];
                    BUFFER.add(producedPart);
                    System.out.println("Producer produced: " + producedPart);
                    BUFFER.notify();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        producer = false;
                    }
                }
            }
     }
}
