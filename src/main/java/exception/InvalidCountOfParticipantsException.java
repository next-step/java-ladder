package exception;

public class InvalidCountOfParticipantsException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "참여자는 1명 이상이어야 합니다.";

    public InvalidCountOfParticipantsException() {
        super(ERROR_MESSAGE);
    }

}
