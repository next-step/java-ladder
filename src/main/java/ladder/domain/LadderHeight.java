package ladder.domain;

public final class LadderHeight {

    private final int height;

    public LadderHeight(int height) {
        this.height = height;
    }

    public static final LadderHeight valueOf(int height) {
        return new LadderHeight(height);
    }
}
