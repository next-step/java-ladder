package ladder.domain.ladder;

import java.util.Objects;
import ladder.strategy.LineGenerateStrategy;

public class Point {

    private static final boolean DISCONNECT_POINT = false;
    private static final int START_POINT_INDEX = 0;
    private static final int VALUE_TO_NEXT_INDEX = 1;

    private final int position;

    private final boolean connected;

    public Point(int position, boolean connected) {
        this.position = position;
        this.connected = connected;
    }

    public int position() {
        return position;
    }

    public boolean connected() {
        return connected;
    }

    public static Point createFirst(LineGenerateStrategy lineGenerateStrategy) {
        return new Point(START_POINT_INDEX, lineGenerateStrategy.generateLine());
    }

    public static Point createLast(Point point) {
        return new Point(point.position + 1, DISCONNECT_POINT);
    }

    public static Point createNextByBeforePoint(Point before, LineGenerateStrategy lineGenerateStrategy) {
        return new Point(before.getNextPosition(), createNextConnect(before, lineGenerateStrategy));
    }

    private static boolean createNextConnect(Point before, LineGenerateStrategy lineGenerateStrategy) {
        return !before.connected && lineGenerateStrategy.generateLine();
    }

    private int getNextPosition() {
        return position + VALUE_TO_NEXT_INDEX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return position == point.position && connected == point.connected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, connected);
    }
}
