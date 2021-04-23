package ladder.domain.ladder;

public final class LadderHeight {

    private final int height;

    private LadderHeight(final int height) {
        this.height = height;
    }

    public static LadderHeight valueOf(final int height) {
        return new LadderHeight(height);
    }
}
