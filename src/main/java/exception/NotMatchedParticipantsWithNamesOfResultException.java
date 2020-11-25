package exception;

public class NotMatchedParticipantsWithNamesOfResultException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "참여자와 결과가 일대일 매칭되지 않습니다.";
    public NotMatchedParticipantsWithNamesOfResultException() {
        super(ERROR_MESSAGE);
    }
}
