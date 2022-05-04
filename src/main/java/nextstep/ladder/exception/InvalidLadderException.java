package nextstep.ladder.exception;

public class InvalidLadderException extends IllegalArgumentException {

    private static final String MESSAGE = "width and height must be over 0. width: %d, height: %d";

    public InvalidLadderException(int width, int height) {
        super(String.format(MESSAGE, width, height));
    }

}
