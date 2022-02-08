package Homework2;

public enum CarColors {
    BLUE("Audi", "Blue"),
    RED("Audi", "Red"),
    GREEN("Audi", "Green"),
    Orange("BMW", "Orange"),
    BLACK("BMW", "Black"),
    VIOLET("BMW", "Violet"),
    YELLOW("KIA", "Yellow"),
    GREY("KIA", "Grey"),
    WHITE("KIA", "White"),
    ;

    private String brand;
    private  String color;

    CarColors(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}

