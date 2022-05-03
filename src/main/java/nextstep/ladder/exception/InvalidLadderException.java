package nextstep.ladder.exception;

public class InvalidLadderException extends IllegalArgumentException {

    public InvalidLadderException(int width, int height) {
        super(buildErrorMessage(width, height));
    }

    private static String buildErrorMessage(int width, int height) {
        return "width and height must be over 0. width: " + width + ", height: " + height;
    }
}
