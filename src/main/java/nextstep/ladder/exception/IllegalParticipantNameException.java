package nextstep.ladder.exception;

public class IllegalParticipantNameException extends IllegalArgumentException {
    private static final String MESSAGE = "참가자의 이름이 비어있거나 길이가 5를 초과하였습니다. (입력된 참가자명: %s)";

    public IllegalParticipantNameException(String value) {
        super(String.format(MESSAGE, value));
    }
}
