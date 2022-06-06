package ladder.exception;

public class NotFoundPlayerException extends RuntimeException{

    public NotFoundPlayerException(String msg) {
        super(msg);
    }
}
