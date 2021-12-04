package nextstep.ladder.domain.point;

import nextstep.ladder.domain.exception.ServiceException;

public class BothWayException extends ServiceException {

    private static final String MESSAGE = "양쪽 모두 길이 있을 수는 없습니다.";

    public BothWayException() {
        super(MESSAGE);
    }
}
