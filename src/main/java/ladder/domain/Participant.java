package ladder.domain;

import static ladder.domain.exception.LadderException.PARTICIPANT_NAME_IS_NULL;
import static ladder.domain.exception.LadderException.PARTICIPANT_NAME_OVER_LIMIT;

public class Participant {

    public static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Participant(String name) {
        this.name = participantValidation(name);
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.name.length();
    }

    public static Participant from(String name) {
        return new Participant(name);
    }

    private String participantValidation(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_IS_NULL.getMessage());
        }

        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_OVER_LIMIT.getMessage());
        }

        return name;
    }

}
