package nextstep.ladder.exception;

import static nextstep.ladder.domain.Participant.MAX_LENGTH;
import static nextstep.ladder.domain.Participant.MIN_LENGTH;

public class InvalidParticipantNameException extends IllegalArgumentException {

    private static final String DEFAULT_ERROR_MESSAGE = "invalid participant name";
    private static final String ERROR_MESSAGE = "name must be length of " + MIN_LENGTH + " to " +
            MAX_LENGTH + ", provided: ";

    public InvalidParticipantNameException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

    public InvalidParticipantNameException(String name) {
        super(buildErrorMessage(name));
    }

    private static String buildErrorMessage(String name) {
        return ERROR_MESSAGE + name;
    }

}
