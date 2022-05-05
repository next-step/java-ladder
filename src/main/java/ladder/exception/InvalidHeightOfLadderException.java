package ladder.exception;

public class InvalidHeightOfLadderException extends RuntimeException {
    private static final String MESSAGE = "사다리 높이는 양수여야 합니다(입력된 높이: %d).";

    public InvalidHeightOfLadderException(int heightOfLadder) {
        super(String.format(MESSAGE, heightOfLadder));
    }
}
