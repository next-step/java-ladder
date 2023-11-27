package nextstep.ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public void validate(int height) {
        checkHeightIsValid(height);
    }

    private void checkHeightIsValid(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 최소 높이는 %d입니다.", height));
        }
    }
}
