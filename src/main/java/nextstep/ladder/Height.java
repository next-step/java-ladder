package nextstep.ladder;

public class Height {
    private static final int MIN_HEIGHT_LENGTH = 1;
    private final int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(final int height) {
        if (height < MIN_HEIGHT_LENGTH) {
            throw new InvalidHeightException("사다리 높이는 최대 " + MIN_HEIGHT_LENGTH +"이상 이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
