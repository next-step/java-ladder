package nextstep.ladder.domain.ladder.size;

import nextstep.ladder.domain.exception.ServiceException;

public class TooShortException extends ServiceException {

    private static final String MESSAGE = "사다리가 너무 짧습니다.";

    public TooShortException() {
        super(MESSAGE);
    }
}
