package ladder.exception;

public class InvalidParticipantNameException extends RuntimeException {
    private static final String MESSAGE_BLANK = "이름이 공백입니다.";
    private static final String MESSAGE_EXCEED_LIMIT = "이름이 %d자를 초과할 수 없습니다. (현재 이름 : %d자)";

    public InvalidParticipantNameException() {
        super(MESSAGE_BLANK);
    }

    public InvalidParticipantNameException(int nameLength, int maxNameLength) {
        super(String.format(MESSAGE_EXCEED_LIMIT, nameLength, maxNameLength));
    }
}
