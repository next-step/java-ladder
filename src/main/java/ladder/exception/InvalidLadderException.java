package ladder.exception;

public class InvalidLadderException extends IllegalArgumentException {

    private static final String MESSAGE = "사다리게임 참여 인원이 부족합니다";

    public InvalidLadderException() {
        super(MESSAGE);
    }

}
