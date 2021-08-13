package nextstep.ladder.domain;

public class LengthLimitException extends IllegalArgumentException {

    public LengthLimitException(String message) {
        super(message);
    }
}
