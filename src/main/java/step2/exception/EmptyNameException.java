package step2.exception;

public class EmptyNameException extends IllegalArgumentException{

    public static final String EMPTY_NAME_EXCEPTION = "이름이 빈값으로 입력이 되었습니다.";

    public EmptyNameException() {
        super(EMPTY_NAME_EXCEPTION);
    }
}
