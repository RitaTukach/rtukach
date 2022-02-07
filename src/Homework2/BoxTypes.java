package Homework2;

public enum BoxTypes {
    CUBE("It is a cube"),
    REGULAR("It is a regular box"),
    ENVELOPE("It is an envelope"),
    ;
    private final String name;
    private int length;
    private int width;
    private int height;

    BoxTypes(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static String identifyBoxType(int length, int width, int height) {
        if (height == length && width == height && width > 0) {
            return CUBE.name;
        }
        else if (height == 0 && width <= length && width > 0) {
            return ENVELOPE.name;
        }
        else if (height > 0 && width <= length && width > 0) {
            return REGULAR.name;
        }
        return "Box type cannot be defined";
    }
}
