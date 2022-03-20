package Homework4.Parameters;

public enum WheelSize {
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    ;

    int size;
    WheelSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
