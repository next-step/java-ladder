package nextstep.ladder.domain.ladder.size;

import nextstep.ladder.domain.exception.ServiceException;

public class LadderSizeException extends ServiceException {
    public LadderSizeException(String message) {
        super(message);
    }
}
