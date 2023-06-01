package ladder.domain;

public class Width {

    private final int width;

    public Width(int width) {
        this.width = width;
    }

    public int getWidthSize() {
        return this.width - 1;
    }

    public static Width from(int width) {
        return new Width(width);
    }

}
