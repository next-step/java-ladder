package nextstep.ladder.domain;

import nextstep.ladder.validator.ParticipantValidator;

import java.util.Objects;

public class Participant {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public static Participant of(String name) {
        return new Participant(name);
    }

    private Participant(String name) {
        ParticipantValidator.validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
