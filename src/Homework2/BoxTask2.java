package Homework2;

//Task2
public class BoxTask2 {
    private int length;
    private int width;
    private int height;

    BoxTask2(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
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

    public String identifyBoxType(BoxTask2 box) {
        if (box.height == box.length && box.width == box.height && box.width > 0) {
            return "It is a cube";
        }
        else if (box.height == 0 && box.width <= box.length && box.width > 0) {
            return "It is an envelope";
        }
        else if (box.height > 0 && box.width <= box.length && box.width > 0) {
            return "It is a regular box";
        }
        return "Box type cannot be defined";
    }
}
