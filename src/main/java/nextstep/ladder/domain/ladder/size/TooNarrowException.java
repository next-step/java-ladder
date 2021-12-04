package nextstep.ladder.domain.ladder.size;

import nextstep.ladder.domain.exception.ServiceException;

public class TooNarrowException extends ServiceException {

    private static final String MESSAGE = "사다리의 폭이 너무 좁습니다.";

    public TooNarrowException() {
        super(MESSAGE);
    }
}
