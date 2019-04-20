package domain;

public class Point {
    private static final String LINE = "|-----";
    private static final String NO_LINE = "|     ";
    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    private boolean isNextPoint(boolean left, BooleanGenerator booleanGenerator) {
        if (left) {
            return false;
        }
        return booleanGenerator.generatePoint();
    }

    public int movePoint() {
        if (this.direction.isRightMovable()) {
            return 1;
        } else if (this.direction.isLeftMovable()) {
            return - 1;
        }
        return 0;
    }

    public static Point first(Level level) {
        return new Point(Direction.generate(false, new BooleanWithLevel(level).generatePoint()));
    }

    public Point next(Level level) {
        boolean isNextPoint = this.direction.isRightMovable();
        return new Point(Direction.generate(isNextPoint, isNextPoint(isNextPoint, new BooleanWithLevel(level))));
    }

    public Point last() {
        boolean isNextPoint = this.direction.isRightMovable();
        return new Point(Direction.generate(isNextPoint, false));
    }

    public String lineType() {
        return this.direction.isRightMovable() ? LINE : NO_LINE;
    }
}
