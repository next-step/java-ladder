package nextstep.ladder.domain.ladder;

public class InvalidLadderHeightException extends RuntimeException {
    private static final String MESSAGE = "사다리 높이는 1이상이어야 합니다.";

    public InvalidLadderHeightException() {
        super(MESSAGE);
    }
}
