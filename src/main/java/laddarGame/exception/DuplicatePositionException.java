package laddarGame.exception;

public class DuplicatePositionException extends IllegalArgumentException {
    public DuplicatePositionException(String message) {
        super(message);
    }
}
