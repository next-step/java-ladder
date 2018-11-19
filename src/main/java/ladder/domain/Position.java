package ladder.domain;

public class Position {

    private static final int ONE = 1;
    private static final int START_POSITION = 0;
    private static final boolean FALSE = false;

    private int position;
    private Direction direction;

    public Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
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
        return new Position(START_POSITION, Direction.of(FALSE, b));
    }

    static Position generateLastPosition(Position prev) {
        return new Position(prev.position + ONE, Direction.of(prev.direction.isRight(), FALSE));
    }

    static Position generateNextPosition(Position prev) {
        return new Position(prev.position + ONE, prev.direction.isOverlapped());
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
}
