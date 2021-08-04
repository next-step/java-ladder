package nextstep.ladder.exception;

public class NotMatchedSizeException extends RuntimeException {
    public NotMatchedSizeException() {
        super("참여할 사람과 실행 결과의 수는 같아야 합니다.");
    }
}
