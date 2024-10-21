package ladder.domain;

public class Ladder {
    private static final int MIN_LENGTH = 1;
    private static final String MIN_LENGTH_ERROR = "사다리 길이는 최소 " + MIN_LENGTH + "이상이어야 합니다.";

    private final int maxLength;

    public Ladder(int maxLength) {
        validateMinLength(maxLength);
        this.maxLength = maxLength;
    }

    private void validateMinLength(int minLength) {
        if (minLength < MIN_LENGTH) {
            throw new IllegalArgumentException(MIN_LENGTH_ERROR);
        }
    }
}
