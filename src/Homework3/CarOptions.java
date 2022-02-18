package Homework3;

public enum CarOptions {
    BLUETOOTH("Bluetooth"),
    CAMERA("Camera"),
    NO_OPTION("No options"),
    ;

    private final String option;

    CarOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        return "CarOptions{" +
                "option='" + option + '\'' +
                '}';
    }
}
