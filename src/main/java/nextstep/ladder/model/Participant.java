package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.Objects;

public final class Participant {

    private static final int MAXIMUM_SIZE = 5;

    private final String name;

    private Participant(String name) {
        Assert.hasText(name, "name must not be blank");
        validateSize(name);
        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(name);
    }

    public String value() {
        return name;
    }

    private void validateSize(String value) {
        if (value.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(String.format("name(%s) length must be equal or less than %d", value, MAXIMUM_SIZE));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant participant = (Participant) o;
        return Objects.equals(name, participant.name);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }
}
