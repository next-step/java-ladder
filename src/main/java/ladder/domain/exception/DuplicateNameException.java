package ladder.domain.exception;

public class DuplicateNameException extends RuntimeException {

    private static final DuplicateNameException DUPLICATE_NAME_EXCEPTION =
            new DuplicateNameException("중복되는 이름은 사용할 수 없습니다.");

    private DuplicateNameException(String message) {
        super(message);
    }

    public static DuplicateNameException getInstance() {
        return DUPLICATE_NAME_EXCEPTION;
    }
}
