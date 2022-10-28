package ladder.exception;

public class EmptyNamesException extends RuntimeException {

    public EmptyNamesException() {
        super("한 사람 이상 등록되어야 합니다.");
    }

}
