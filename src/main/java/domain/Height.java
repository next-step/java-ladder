package domain;

public class Height {

    public static final int MIN_HEIGHT = 1;

    private final int value;

    public Height(int value) {
        assertGreaterThenMinHeight(value);
        this.value = value;
    }

    private static void assertGreaterThenMinHeight(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1보다 커야합니다.");
        }
    }

    public int height() {
        return this.value;
    }
}
