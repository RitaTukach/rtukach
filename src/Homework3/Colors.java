package Homework3;

public enum Colors {
    YELLOW("yellow"),
    WHITE("white"),
    BLACK("black"),
    GRAY("gray"),
    RED("red")
    ;
    String colorName;

    public String getColorName() {
        return colorName;
    }

    Colors(String colorName){
        this.colorName = colorName;


    }
}
