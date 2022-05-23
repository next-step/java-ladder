package nextstep.ladder.exception;

public class NameLengthExceedException extends RuntimeException {

    private static final String OUT_OF_LENGTH_MESSAGE = "이름의 길이를 초과했습니다. 이름은 최대 5자까지 허용합니다.";

    public NameLengthExceedException() {
        super(OUT_OF_LENGTH_MESSAGE);
    }
}
