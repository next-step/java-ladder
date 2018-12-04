package ladder.exception;

public class NotFindMatchNameException extends RuntimeException {

    public static final String NOT_FOUNT_MATCH_NAME = "등록되지 않은 이름입니다.";

    public NotFindMatchNameException() {
        super(NOT_FOUNT_MATCH_NAME);
    }


}
