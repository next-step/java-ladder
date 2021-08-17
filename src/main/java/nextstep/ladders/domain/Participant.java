package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.NameLengthInvalidException;

public class Participant {

    private final String name;

    public Participant(final String name) {
        if (name.length() > 5) {
            throw new NameLengthInvalidException();
        }
        this.name = name;
    }
}
