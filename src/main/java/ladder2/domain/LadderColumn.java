package ladder2.domain;

import java.util.Objects;

public class LadderColumn {

    private final Position position;
    private final Link link;

    public LadderColumn(int position, Link link) {
        this(new Position(position), link);
    }

    public LadderColumn(Position position, Link link) {
        this.position = position;
        this.link = link;
    }

    public Position nextPosition() {
        return link.nextPosition(position);
    }

    public int position() {
        return position.value();
    }

    public Link link() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderColumn that = (LadderColumn) o;
        return Objects.equals(position, that.position) && link == that.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, link);
    }

    @Override
    public String toString() {
        return "LadderColumn{" +
            "position=" + position +
            ", link=" + link +
            '}';
    }
}
