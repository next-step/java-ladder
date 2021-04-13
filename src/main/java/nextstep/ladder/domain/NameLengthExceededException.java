package nextstep.ladder.domain;

public class NameLengthExceededException extends IllegalArgumentException {

    public NameLengthExceededException(String message) {
        super(message);
    }
}
