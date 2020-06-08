package ladder.step4.exception;

public class ParticipantNameMaximumSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "참여자 이름은 최대 5글자 이하여야합니다.";

    public ParticipantNameMaximumSizeException() {
        super(ERROR_MESSAGE);
    }

}
