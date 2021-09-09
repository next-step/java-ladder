package ladder.domain.ladder;

import static java.util.Objects.isNull;

import java.util.Objects;
import ladder.strategy.LineGenerateStrategy;

public class Point {

    private static final boolean DISCONNECT_POINT = false;
    private static final int START_POINT_INDEX = 0;
    private static final int VALUE_TO_MOVE_INDEX = 1;

    private static final String PREV_NEXT_CONNECT_ERROR_MESSAGE = "Point는 왼쪽 오른쪽 둘 다 연결될 수 없다.";
    private static final String NULL_BEFORE_POINT_ERROR_MESSAGE = "이전 위치한 Point가 제공되어야 한다.";

    private final int position;

    private final boolean prevConnect;
    private final boolean nextConnect;

    public Point(int position, boolean prevConnect, boolean nextConnect) {
        checkPrevNextPoint(prevConnect, nextConnect);

        this.position = position;
        this.prevConnect = prevConnect;
        this.nextConnect = nextConnect;
    }

    private static void checkPrevNextPoint(boolean prevConnect, boolean nextConnect) {
        if (prevConnect && nextConnect) {
            throw new IllegalArgumentException(PREV_NEXT_CONNECT_ERROR_MESSAGE);
        }
    }

    public static Point createFirst(LineGenerateStrategy lineGenerateStrategy) {
        return new Point(START_POINT_INDEX, DISCONNECT_POINT, lineGenerateStrategy.generateLine());
    }

    public static Point createLast(Point before) {
        checkBeforePointIsNull(before);

        return new Point(before.getNextPosition(), before.nextConnect, DISCONNECT_POINT);
    }

    public static Point createNextByBeforePoint(Point before, LineGenerateStrategy lineGenerateStrategy) {
        checkBeforePointIsNull(before);

        return new Point(before.getNextPosition(), before.nextConnect, createNextConnect(before, lineGenerateStrategy));
    }

    private static void checkBeforePointIsNull(Point before) {
        if (isNull(before)) {
            throw new IllegalArgumentException(NULL_BEFORE_POINT_ERROR_MESSAGE);
        }
    }

    private static boolean createNextConnect(Point before, LineGenerateStrategy lineGenerateStrategy) {
        return !before.nextConnect && lineGenerateStrategy.generateLine();
    }

    private int getNextPosition() {
        return position + VALUE_TO_MOVE_INDEX;
    }

    public boolean isPrevConnect() {
        return prevConnect;
    }

    public boolean isNextConnect() {
        return nextConnect;
    }

    public int move() {
        if (isNextConnect()) {
            return position + VALUE_TO_MOVE_INDEX;
        }
        if (isPrevConnect()) {
            return position - VALUE_TO_MOVE_INDEX;
        }
        return position;
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
        return position == point.position && prevConnect == point.prevConnect && nextConnect == point.nextConnect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, prevConnect, nextConnect);
    }

}
