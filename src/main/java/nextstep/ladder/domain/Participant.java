package nextstep.ladder.domain;

import nextstep.ladder.exception.InvalidParticipantNameException;

import java.util.Objects;

public class Participant {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    private final String name;

    Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidParticipantNameException();
        }
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new InvalidParticipantNameException(name);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
