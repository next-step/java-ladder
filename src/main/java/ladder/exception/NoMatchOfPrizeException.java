package ladder.exception;

public class NoMatchOfPrizeException extends RuntimeException {
    private static final String MESSAGE = "사다리 게임에 일치하는 결과가 없습니다. (참가자 : %d)";

    public NoMatchOfPrizeException(String participantName) {
        super(String.format(MESSAGE, participantName));
    }
}
