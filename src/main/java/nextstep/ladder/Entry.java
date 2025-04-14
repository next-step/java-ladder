package nextstep.ladder;

import java.util.Objects;

public class Entry {
    private Name name;
    private Position position;

    public Entry(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Entry(String name, Position position) {
        this(new Name(name), position);
    }

    public void move(Direction direction) {
        this.position.move(direction);
    }

    public boolean isSamePosition(Entry entry) {
        return this.position.equals(entry.position);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public String toStringWithBlank() {
        return name.toStringWithBlank();
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry entry = (Entry) o;

        if (!position.equals(entry.position)) return false;
        return Objects.equals(name, entry.name);
    }
}
