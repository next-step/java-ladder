package ladder.domain;

public class LadderHeight {
    private int height;

    public LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight from(int height) {
        return new LadderHeight(height);
    }

    public int size() {
        return height;
    }
}
