package step03.domain;

import java.util.Objects;

public class Participant {
    private final Name name;

    private Participant(Name name) {
        this.name = name;
    }

    public static Participant of(String name) {
        return new Participant(Name.of(name));
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
        return name.toString() + "";
    }
}
