package exception;

public class InvalidCountOfNamesException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "이름은 1개 이상이어야 합니다.";

    public InvalidCountOfNamesException() {
        super(ERROR_MESSAGE);
    }

}
