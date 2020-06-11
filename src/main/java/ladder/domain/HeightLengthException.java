package ladder.domain;

public class HeightLengthException extends RuntimeException {
    public static final String MESSAGE = "사다리 높이는 1 이상이어야 합니다.";

    public HeightLengthException() {
        super(MESSAGE);
    }
}
