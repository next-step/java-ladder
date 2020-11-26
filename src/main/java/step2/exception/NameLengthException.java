package step2.exception;

public class NameLengthException extends IllegalArgumentException{

    public static final String NAME_LENGTH_EXCEPTION = "이름은 5글자까지 입니다.";

    public NameLengthException() {
        super(NAME_LENGTH_EXCEPTION);
    }
}
