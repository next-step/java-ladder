package ladder.step4.exception;

public class ParticipantsMinimumSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "참여자는 최소 2명 이상필요합니다.";

    public ParticipantsMinimumSizeException() {
        super(ERROR_MESSAGE);
    }

}
