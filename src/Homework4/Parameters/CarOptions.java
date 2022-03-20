package Homework4.Parameters;

public enum CarOptions {
    BLUETOOTH("Bluetooth"),
    CAMERA("Camera"),
    WHEEL_HEATING("Wheel heating"),
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
