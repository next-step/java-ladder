package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.ServiceException;

public class UnRegisteredParticipantException extends ServiceException {

    private static final String MESSAGE = "등록되지않은 참가자입니다.";

    public UnRegisteredParticipantException() {
        super(MESSAGE);
    }
}
