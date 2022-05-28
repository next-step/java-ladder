package ladder.exception;

public class NotFoundResultException extends RuntimeException {

    private static final String MESSAGE = "Players 중에 이동이 끝나지 않은 Player 가 있어 결과를 찾을 수 없습니다.";

    public NotFoundResultException() {
        super(MESSAGE);
    }
}
