package ladder.domain;

import ladder.constant.Direction;

import java.util.Objects;

public class Element {

    private final Name name;
    private final Position position;

    public Element(String name, int maxPosition, int position) {
        this(name, new Position(maxPosition, position));
    }

    public Element(String name, Position position) {
        this(new Name(name), position);
    }

    public Element(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name name() {
        return name;
    }

    public int withoutNameSize(int maxSize) {
        return maxSize - name.size();
    }

    public int nameSize() {
        return name.size();
    }

    public void move(Direction direction) {
        position.change(direction);
    }

    public Position position() {
        return position;
    }

    public boolean sameName(Name name) {
        return this.name.equals(name);
    }

    public boolean samePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(name, element.name) && Objects.equals(position, element.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
