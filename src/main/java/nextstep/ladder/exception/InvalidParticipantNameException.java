package nextstep.ladder.exception;

import static nextstep.ladder.domain.Participant.MAX_LENGTH;
import static nextstep.ladder.domain.Participant.MIN_LENGTH;

public class InvalidParticipantNameException extends IllegalArgumentException {

    private static final String DEFAULT_ERROR_MESSAGE = "invalid participant name";
    private static final String ERROR_MESSAGE = "name must be length of %d to %d, provided: %s";

    public InvalidParticipantNameException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

    public InvalidParticipantNameException(String name) {
        super(buildErrorMessage(name));
    }

    private static String buildErrorMessage(String name) {
        return String.format(ERROR_MESSAGE, MIN_LENGTH, MAX_LENGTH, name);
    }

}
