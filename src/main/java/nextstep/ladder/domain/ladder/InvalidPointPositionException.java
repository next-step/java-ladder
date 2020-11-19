package nextstep.ladder.domain.ladder;

public class InvalidPointPositionException extends RuntimeException {
    private static final String MESSAGE = "포인트의 위치는 0이상이고 최대로 지정된 위치보다 작아야 합니다.";

    public InvalidPointPositionException() {
        super(MESSAGE);
    }
}
