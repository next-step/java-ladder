package nextstep.ladder.domain;

import nextstep.ladder.validator.ParticipantValidator;

public class Participant {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        ParticipantValidator.validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
