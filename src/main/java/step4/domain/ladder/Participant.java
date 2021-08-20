package step4.domain.ladder;

import java.util.Objects;

public class Participant {
    private final String name;

    public String nameOf() {
        return name;
    }

    private Participant(String name) {
        this.name = name;
    }

    public static Participant of(String name) {
        return new Participant(name);
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
