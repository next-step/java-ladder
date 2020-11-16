package nextstep.ladder.domain.ladder;

public final class LadderHeight {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final int height;

    private LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight of(int height) {
        validateHeight(height);
        return new LadderHeight(height);
    }

    private static void validateHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new InvalidLadderHeightException();
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LadderHeight that = (LadderHeight) o;

        return height == that.height;
    }

    @Override
    public int hashCode() {
        return height;
    }
}
