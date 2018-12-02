package ladder.model;

import java.util.Objects;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    private Participant(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(name);
    }

    public boolean isMatch(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
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
