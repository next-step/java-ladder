package ladder.domain;

import ladder.exception.InvalidParticipantNameException;
import ladder.utils.StringUtils;

public class ParticipantName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    ParticipantName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InvalidParticipantNameException();
        }

        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new InvalidParticipantNameException(name.trim().length(), MAX_NAME_LENGTH);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
