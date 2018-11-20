package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private static final int ONE = 1;
    private static final int START_POSITION = 0;
    private static final boolean FALSE = false;

    private static final Map<String, Position> reusablePosition = new HashMap<>();

    private int position;
    private Direction direction;

    public Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Position getInstance(int pos, Direction dir) {
        String key = pos + "" + dir.isRight() + "" + dir.isLeft();

        if(!reusablePosition.containsKey(key)) {
            Position position = new Position(pos, dir);
            reusablePosition.put(key, position);
        }
        return reusablePosition.get(key);
    }

    public int move() {
        if (this.direction.isRight()) {
            return this.position + ONE;
        }

        if (this.direction.isLeft()) {
            return this.position - ONE;
        }

        return this.position;
    }

    static Position generateFirstPosition(boolean b) {
        return Position.getInstance(START_POSITION, Direction.of(FALSE, b));
    }

    static Position generateLastPosition(Position prev) {
        return Position.getInstance(prev.position + ONE, Direction.of(prev.direction.isRight(), FALSE));
    }

    static Position generateNextPosition(Position prev) {
        return Position.getInstance(prev.position + ONE, prev.direction.isOverlapped());
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        if(this.direction.isRight()) {
            return "-----";
        }

        return "     ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position &&
                Objects.equals(direction, position1.direction);
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, direction);
    }
}
