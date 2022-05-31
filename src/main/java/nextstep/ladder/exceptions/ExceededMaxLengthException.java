package nextstep.ladder.exceptions;

public class ExceededMaxLengthException extends IllegalArgumentException {
    public ExceededMaxLengthException(String s) {
        super(s);
    }
}
