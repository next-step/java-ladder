package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {

    private final Name name;

    public Participant(String name) {
        this.name = new Name(name);
    }

    public Participant(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Name getName() {
        return name;
    }
}
