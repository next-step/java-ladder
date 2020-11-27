package exception;

public class UsingProhibitedNameException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "이름에 금지된 단어를 사용하였습니다.";
    public UsingProhibitedNameException() {
        super(ERROR_MESSAGE);
    }
}
