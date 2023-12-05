package ladder.domain.data;

import static ladder.domain.data.Name.NAME_SIZE;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public boolean equalsHorizontal() {
        return direction == Direction.HORIZONTAL;
    }

    public String addIndent() {
        String character = direction.character();
        if (direction.isHorizontal() || direction.isNone()) {
            return character.repeat(NAME_SIZE);
        }
        return character;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point) object;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return direction.hashCode();
    }

}
