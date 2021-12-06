package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.ServiceException;

import static java.lang.String.format;

public class TooFewParticipantsException extends ServiceException {

    private static final String FORMATTED_MESSAGE = "참가자 수는 %d 이상 이어야 합니다.";

    public TooFewParticipantsException(int minNumberOfParticipants) {
        super(format(FORMATTED_MESSAGE, minNumberOfParticipants));
    }
}
