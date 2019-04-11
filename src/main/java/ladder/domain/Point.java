package ladder.domain;

public class Point {
    private static final String EMPTY_LINE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if(direction.isRight()) {
            return index + 1;
        }
        if(direction.isLeft()) {
            return index - 1;
        }
        return this.index;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(VERTICAL_LINE);
        if(direction.isRight()) {
            stringBuffer.append(HORIZONTAL_LINE);
        }
        if(direction.isLeft()) {
            stringBuffer.append(EMPTY_LINE);
        }
        if(direction.isCenter()) {
            stringBuffer.append(EMPTY_LINE);
        }

        return stringBuffer.toString();
    }
}
