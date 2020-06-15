package laddergame.domain.ladder;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validateHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다. - " + height);
        }
    }
}
