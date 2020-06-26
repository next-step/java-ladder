package nextstep.ladder.domain.line;

import nextstep.ladder.generator.LadderPointGenerator;

public class Point {
    private static final String POINT_LINED = "-----|";
    private static final String POINT_UNLINED = "     |";

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next(LadderPointGenerator ladderPointGenerator) {
        return new Point(index + 1, direction.next(ladderPointGenerator));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return direction.isRight() ? POINT_LINED : POINT_UNLINED;
    }
}
