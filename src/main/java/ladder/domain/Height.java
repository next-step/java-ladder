package ladder.domain;

public class Height {
    private static final int MIN_LENGTH = 1;
    private final int length;

    public Height(int length) {
        validateLength(length);
        this.length = length;
    }

    private void validateLength(int length) {
        if (length < MIN_LENGTH) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public int getLength() {
        return length;
    }
}
