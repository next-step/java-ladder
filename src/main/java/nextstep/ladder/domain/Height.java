package nextstep.ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 최소 %d 이상이어야 합니다.", MIN_HEIGHT));
        }
    }
}
