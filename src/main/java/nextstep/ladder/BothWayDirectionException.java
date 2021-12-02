package nextstep.ladder;

public class BothWayDirectionException extends ServiceException {

    private static final String MESSAGE = "양쪽 모두 길이 있을 수는 없습니다.";

    public BothWayDirectionException() {
        super(MESSAGE);
    }
}
