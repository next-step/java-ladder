package step4_ladderGame.exception;

public class DuplicatePositionException extends IllegalArgumentException {
    public DuplicatePositionException(String message) {
        super(message);
    }
}
