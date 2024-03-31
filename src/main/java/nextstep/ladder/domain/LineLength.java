package nextstep.ladder.domain;

public class LineLength {
    private final int length;
    private final int MIN_LENGTH = 2;

    public LineLength(int length) {
        assertValidLength(length);
        this.length = length;
    }

    private void assertValidLength(int length) {
        String message = String.format("[라인] 길이는 %d 이상만 가능합니다.", MIN_LENGTH);
        if (length < MIN_LENGTH) {
            throw new IllegalArgumentException(message);
        }
    }

    public int getLength() {
        return length;
    }
}
