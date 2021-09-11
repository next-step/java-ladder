package ladder.exception;

public class InvalidParticipantsCountException extends RuntimeException {
    private static final String MESSAGE = "입력된 참가자 수가 유효하지 않습니다. (참가자 수 : %d, 최소 값 : %d)";

    public InvalidParticipantsCountException(int countOfParticipants, int lowerLimit) {
        super(String.format(MESSAGE, countOfParticipants, lowerLimit));
    }
}
