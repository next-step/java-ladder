package ladder.exception;

public class InvalidQueryException extends RuntimeException {

    public static final String INVALID_QUERY_MESSAGE = "입력하신 사다리 게임 참여자 중 없는 이름입니다.";

    public InvalidQueryException() {
        this(INVALID_QUERY_MESSAGE);
    }

    public InvalidQueryException(String message) {
        super(message);
    }
}
