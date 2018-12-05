package ladder.model;

import java.util.Objects;

public class Position {
    private static final Integer FIRST_POSITION_INDEX = 0;

    private Integer position;

    private Position(Integer position) {
        this.position = position;
    }

    public static Position of(Integer position) {
       return new Position(position);
    }

    public Integer getPosition() {
        return position;
    }

    public Position decrement() {
        if(position == FIRST_POSITION_INDEX) {
            throw new RuntimeException();
        }

        this.position--;
        return this;
    }
    public Position increment() {
        this.position++;
        return this;
    }

    public Direction getDirection(Line line) {
        if(isFirst())
            return Direction.of(Boolean.FALSE, line.isRightPoint(position));

        if(isLast(line))
            return Direction.of(line.isLeftPoint(position), Boolean.FALSE);

        return Direction.of(line.isLeftPoint(position), line.isRightPoint(position));
    }

    private boolean isFirst() {
        return position == FIRST_POSITION_INDEX;
    }

    private boolean isLast(Line line) {
        return position == line.size() - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
