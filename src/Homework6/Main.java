package Homework6;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Factory factory = new Factory();
        Country1 country1 = new Country1(factory);
        Country2 country2 = new Country2(factory);

        Thread factoryThread = new Thread(factory::produceRobotPart);
        Thread countryOne = new Thread(country1);
        Thread countryTwo = new Thread(country2);

        factoryThread.start();
        countryOne.start();
        countryTwo.start();

        factoryThread.join();
        countryOne.join();
        countryTwo.join();

    }
}
