package nextstep.laddergame.model;

import java.util.Objects;

public class Participant {

    private final Name name;

    public Participant(Name name) {
        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(new Name(name));
    }

    public Name name() {
        return name;
    }

    public boolean isAll() {
        return name.equals(Name.ALL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
