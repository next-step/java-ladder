package exception;

public class OutOfNameLengthException extends IllegalArgumentException{
    private final static String ERROR_MESSAGE = "이름의 길이는 1 이상 5 이하이여야 합니다.";

    public OutOfNameLengthException() {
        super(ERROR_MESSAGE);
    }
}
