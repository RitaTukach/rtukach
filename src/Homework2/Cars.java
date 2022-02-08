package Homework2;

public class Cars {

    public static void main(String[] args) {
        Cars car = new Cars("BMW", "Black");
        String colorForChange = "Violet";
        car.changeColor(colorForChange);
        Cars carAfterChange = new Cars(car.getBrand(), car.changeColor(colorForChange));
        System.out.println(carAfterChange.brand + ", " + carAfterChange.color);
    }
    private final String brand;
    private String color;

    public Cars(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return brand + ", " + color;
    }

    public String changeColor(String color) {
        for(CarColors carColors: CarColors.values()) {
            if (carColors.getBrand().equals(this.getBrand()) && carColors.getColor().equals(color)) {
                this.color = color;
            }
        }
        return this.color;
    }
}
