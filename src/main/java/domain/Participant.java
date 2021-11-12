package domain;

import java.util.Objects;

public class Participant {
    private Name name;

    public Participant(String name) {
        this.name = new Name(name);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Participant other = (Participant) object;

        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
