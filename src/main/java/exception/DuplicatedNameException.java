package exception;

public class DuplicatedNameException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "중복된 이름이 존재하면 안됩니다.";

    public DuplicatedNameException() {
        super(ERROR_MESSAGE);
    }
}
