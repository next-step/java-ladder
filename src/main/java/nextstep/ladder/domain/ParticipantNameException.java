package nextstep.ladder.domain;

import static nextstep.ladder.domain.Participant.MAX_LENGTH;
import static nextstep.ladder.domain.Participant.MIN_LENGTH;

public class ParticipantNameException extends IllegalArgumentException {

    public ParticipantNameException() {
        super("invalid participant name");
    }

    public ParticipantNameException(String name) {
        super(buildErrorMessage(name));
    }

    public ParticipantNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParticipantNameException(Throwable cause) {
        super(cause);
    }

    private static String buildErrorMessage(String name) {
        return "name must be length of " + MIN_LENGTH + " to " + MAX_LENGTH + " provided: " + name;
    }
}
