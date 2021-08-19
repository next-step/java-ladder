package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.NameLengthInvalidException;

public class Participant {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private Participant(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameLengthInvalidException();
        }
        this.name = name;
    }

    public static Participant valueOf(final String name) {
        return new Participant(name);
    }

    public String value() {
        return name;
    }
}
