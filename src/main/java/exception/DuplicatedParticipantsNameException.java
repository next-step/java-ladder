package exception;

public class DuplicatedParticipantsNameException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "중복된 참여자 이름이 존재하면 안됩니다.";

    public DuplicatedParticipantsNameException() {
        super(ERROR_MESSAGE);
    }
}
