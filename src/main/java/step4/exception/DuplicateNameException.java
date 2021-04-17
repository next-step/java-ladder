package step4.exception;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException(String message) {
        super(message);
    }
}
