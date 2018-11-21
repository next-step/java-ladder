package ladder.exception;

public class FormatException extends RuntimeException {

    public static final String ILLEGAL_STANDARD_LENGTH = "표준 글자수가 아닙니다.(5자 이내)";

    public FormatException() {
        super(ILLEGAL_STANDARD_LENGTH);
    }


}