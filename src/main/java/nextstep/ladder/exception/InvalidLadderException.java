package nextstep.ladder.exception;

public class InvalidLadderException extends IllegalArgumentException {

    private static final String MESSAGE = "width and height must be over 0. width: %d, height: %d";

    public InvalidLadderException(int width, int height) {
        super(buildErrorMessage(width, height));
    }

    private static String buildErrorMessage(int width, int height) {
        return String.format(MESSAGE, width, height);
    }
}
