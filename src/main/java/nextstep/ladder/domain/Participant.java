package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {
    private final Name name;
    private int position;

    public Participant(String name) {
        this(name, 0);
    }

    public Participant(String name, int position) {
        this(new Name(name), position);
    }

    public Participant(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public int position() {
        return position;
    }

    public void move(LadderLine line) {
        this.position = line.getNextPosition(position);
    }

    public Name name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
