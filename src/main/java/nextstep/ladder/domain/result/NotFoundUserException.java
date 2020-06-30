package nextstep.ladder.domain.result;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String message) {
        super(message);
    }
}
