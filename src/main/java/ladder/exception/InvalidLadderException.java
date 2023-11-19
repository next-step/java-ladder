package ladder.exception;

public class InvalidLadderException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리게임 참여는 2명 이상부터 가능합니다";

    public InvalidLadderException() {
        super(MESSAGE);
    }

}
