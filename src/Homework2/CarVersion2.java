package Homework2;

public class CarVersion2 {

    public static void main(String[] args) {
        CarVersion2 carVersion2 = new CarVersion2(carTypes.KIA, carTypes.KIA.color2);
        String colorForChange = "Yellow";
        CarVersion2 carVersion21 = new CarVersion2(carVersion2.getBrand(), carVersion2.changeColor(colorForChange));
        System.out.println(carVersion21.toString());
    }

    private carTypes brand;
    private String color;

    CarVersion2(carTypes brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public carTypes getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String changeColor(String color) {

        if (color.equals(brand.color1)) {
            this.color = brand.color1;
        }
        else if (color.equals(brand.color2)) {
            this.color = brand.color2;
        }
        else if (color.equals(brand.color3)) {
            this.color = brand.color3;
        }
        return this.color;
    }

    public String toString() {
        return brand + ", " + color;
    }
    public enum carTypes {
        AUDI( "Blue", "Red", "Green"),
        BMW("Orange", "Black", "Violet"),
        KIA( "Yellow", "Gray", "White"),
        ;

        private String color1;
        private String color2;
        private String color3;

        carTypes( String color1, String color2, String color3) {
            this.color1 = color1;
            this.color2 = color2;
            this.color3 = color3;
        }
    }
}
