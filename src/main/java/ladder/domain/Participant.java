package ladder.domain;

import java.util.Objects;

public class Participant {
    private final Name name;

    private Participant(Name name) {
        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(Name.from(name));
    }

    public String name() {
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

    @Override
    public String toString() {
        return "Participant{" +
                "name=" + name +
                '}';
    }
}
