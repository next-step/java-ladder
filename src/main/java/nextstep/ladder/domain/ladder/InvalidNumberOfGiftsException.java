package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.ServiceException;

public class InvalidNumberOfGiftsException extends ServiceException {

    private static final String MESSAGE = "참여자의 수와 선물의 수가 같지 않습니다.";

    public InvalidNumberOfGiftsException() {
        super(MESSAGE);
    }
}
