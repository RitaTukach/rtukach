package Homework2;

public class BoxTypeVersion2 {
    public enum BoxesNames {

        CUBE("It is a cube"),
        REGULAR("It is a regular box"),
        ENVELOPE("It is an envelope"),
        ;
        private String name;

        BoxesNames(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
    private String box;
    private int length;
    private int width;
    private int height;

    BoxTypeVersion2(int length) {
        this.length = length;
    }
    BoxTypeVersion2(int length, int width) {
        this.width = width;
        this.length = length;
    }
    BoxTypeVersion2(int length, int width, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public String getBox() {
        return box;
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

    public String identifyBoxType() {
        if (this.width == 0 && this.height == 0 && length > 0) {
            this.box = BoxesNames.CUBE.getName();
        } else if (this.height == 0 && this.width <= this.length && this.width > 0) {
            this.box = BoxesNames.ENVELOPE.getName(); //if height == 0
        } else if (this.height > 0 && this.width <= this.length && this.width > 0) {
            this.box = BoxesNames.REGULAR.getName();
        } else {
            this.box = "Not a Box";
        }
        return this.box;
    }

    public static void main(String[] args) {
        BoxTypeVersion2 boxTypes1 = new BoxTypeVersion2(0);
        BoxTypeVersion2 boxTypes2 = new BoxTypeVersion2(5, 0);
        BoxTypeVersion2 boxTypes3 = new BoxTypeVersion2(10, 7, 0);
        System.out.println(boxTypes1.identifyBoxType());
        System.out.println(boxTypes2.identifyBoxType());
        System.out.println(boxTypes3.identifyBoxType());
    }
}

