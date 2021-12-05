package step2.domain;

import java.util.Objects;

public class Participant {
    private final Name name;

    private Participant(String name) {
        this.name = Name.of(name);
    }

    public static Participant of(String name) {
        return new Participant(name);
    }

    public String getName() {
        return name.getName();
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
