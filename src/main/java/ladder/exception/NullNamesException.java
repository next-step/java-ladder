package ladder.exception;

public class NullNamesException extends RuntimeException {

    public NullNamesException() {
        super("이름들은 null 이면 안됩니다.");
    }

}
