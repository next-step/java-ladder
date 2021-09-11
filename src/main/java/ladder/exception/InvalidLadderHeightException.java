package ladder.exception;

public class InvalidLadderHeightException extends RuntimeException {
    private static final String MESSAGE = "입력된 사다리 높이가 유효하지 않습니다. (사다리 높이 : %d, 최소 값 : %d)";

    public InvalidLadderHeightException(int ladderHeight, int lowerLimint) {
        super(String.format(MESSAGE, ladderHeight, lowerLimint));
    }
}
