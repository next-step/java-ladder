package ladder.domain;

import java.util.Objects;

public class Participant {
    private final Name name;
    private final Position position;

    public Participant(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Participant(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean hasSameName(String name) {
        return this.name.equals(new Name(name));
    }

    public int getPosition() {
        return this.position.getPosition();
    }
    public int getPrizeIndex(Ladder ladder) {
        return this.position.findPrizeIndex(ladder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

}
