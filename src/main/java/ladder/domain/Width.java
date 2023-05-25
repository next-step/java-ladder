package ladder.domain;

public class Width {

    private final int width;

    public Width(int width) {
        this.width = width;
    }

    public int getWidthCount() {
        return this.width;
    }

    public static Width from(int width) {
        return new Width(width);
    }

}
