package nextstep.ladder.domain;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String message) {
        super(message);
    }
}
