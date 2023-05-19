package nextstep.ladder.domain;

public class Height {

    private final int height;
    private static final int MIN_HEIGHT = 1;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
