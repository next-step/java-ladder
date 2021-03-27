package laddarGame.exception;

public class NonMatchPlayerException extends IllegalArgumentException {
    public NonMatchPlayerException(String message) {
        super(message);
    }
}
