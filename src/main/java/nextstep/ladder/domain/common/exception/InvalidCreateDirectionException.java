package nextstep.ladder.domain.common.exception;

public class InvalidCreateDirectionException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 방향 초기 값 입니다.";

    public InvalidCreateDirectionException() {
        super(MESSAGE);
    }
}
