package ladder.domain;


public class NotFoundUserByNameException extends IllegalArgumentException {
    public NotFoundUserByNameException(String message) {
        super(message);
    }
}
