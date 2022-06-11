package nextstep.ladder.exceptions;

public class OutOfMaxNameLengthException extends IllegalArgumentException {
    public OutOfMaxNameLengthException(String s) {
        super(s);
    }
}
