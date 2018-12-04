package ladder.domain;

public class LadderWidth {

    private int width;

    public LadderWidth(int width) {
        this.width = width;
    }

    public static LadderWidth from(int width) {
        return new LadderWidth(width);
    }

    public int size() {
        return width;
    }
}
