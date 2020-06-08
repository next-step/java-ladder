package ladder.step4.exception;

public class ParticipantNameEmptyException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "참여자의 이름을 한 글자 이상 입력해주세요";

    public ParticipantNameEmptyException() {
        super(ERROR_MESSAGE);
    }

}
