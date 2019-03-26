package laddergame.domain;

import laddergame.validator.ParticipantValidator;
import laddergame.validator.Validatable;

import java.util.Objects;

public class Participant {

    private Validatable<String> validator = new ParticipantValidator();
    private final String name;

    public Participant(String name) {
        validator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getResultName() {
        return String.format("%5s", name);
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

    @Override
    public String toString() {
        return name;
    }
}