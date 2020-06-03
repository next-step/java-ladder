package ladder.domain.ladder;

public class Height {

    public static final int MIN_HEIGHT = 1;

    private final int value;

    private Height(final int value) {
        verifyHeight(value);
        this.value = value;
    }

    public static Height of(final int value) {
        return new Height(value);
    }

    private static void verifyHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1 이상이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
