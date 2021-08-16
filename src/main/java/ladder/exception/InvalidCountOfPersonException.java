package ladder.exception;

public class InvalidCountOfPersonException extends IllegalArgumentException {
    private static final String MESSAGE = "사다리 게임의 최소 필요 인원은 2명 이상 입니다.";

    public InvalidCountOfPersonException() {
        super(MESSAGE);
    }
}
