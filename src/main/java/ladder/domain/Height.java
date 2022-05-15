package ladder.domain;

public class Height {
    private static final int MIN_VALUE_OF_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_VALUE_OF_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1보다 작을 수 없습니다");
        }
    }
}
