package nextstep.ladder.domain;

public class Position {
    private static final int ZERO = 0;
    private static final int ADD_NUMBER = 2;

    private final int position;
    private final Direction direction;

    private Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Position of(int position, Direction direction) {
        return new Position(position, direction);
    }

    public static Position of(int position, Lines lines) {

        return new Position(position, direction(lines, position));
    }

    public int move() {

        if (direction == Direction.LEFT) {
            zeroValidate();
            return position - ADD_NUMBER;
        }

        if (direction == Direction.RIGHT) {
            return position + ADD_NUMBER;
        }

        return position;
    }

    private void zeroValidate() {
        if(position == ZERO) {
            throw new IllegalArgumentException("맨 왼쪽이므로 왼쪽으로 더는 갈 수 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public static Direction direction(Lines lines, int position) {
        if(lines.findLines(position - 2)) {
            return Direction.LEFT;
        }

        if(lines.findLines(position + 2)) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }
}