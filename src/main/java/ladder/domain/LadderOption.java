package ladder.domain;

public class LadderOption {

    private int height;

    private LadderOption(int height) {
        this.height = height;
    }

    public static LadderOption create(int height) {
        return new LadderOption(height);
    }

    public int height() {
        return this.height;
    }
}
