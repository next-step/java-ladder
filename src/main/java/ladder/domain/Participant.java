package ladder.domain;

import java.util.Objects;

public class Participant {

    private final Name name;
    private int position;

    // TODO: validation
    public Participant(final String name, final int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void changePosition(final int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Participant)) {
            return false;
        }

        Participant that = (Participant) o;

        if (this.name != that.name) {
            return false;
        }

        return this.position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
