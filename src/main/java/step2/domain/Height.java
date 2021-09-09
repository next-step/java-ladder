package step2.domain;

public class Height {
    private static final String MIN_HEIGHT_ERROR_MESSAGE = "높이는 1보다 작을 수 없습니다.";
    private static final int MIN_HEIGHT = 1;
    private final int value;

    public Height(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT_ERROR_MESSAGE);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}