package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Point {
    public static final String EXCEPTION_BOTH_TRUE = "가로 라인은 한 좌표에 하나만 가질 수 있습니다.";
    private static final boolean INITIAL_LEFT = false;
    private static final boolean INITIAL_RIGHT = false;
    private boolean left;
    private boolean right;

    public Point() {
        this(INITIAL_LEFT, INITIAL_RIGHT);
    }

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(EXCEPTION_BOTH_TRUE);
        }
        this.left = left;
        this.right = right;
    }

    public static List<Point> createInitialPoints(int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Point())
                .collect(Collectors.toList());
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    private void connectLeft() {
        if (isRight()) {
            throw new IllegalArgumentException(EXCEPTION_BOTH_TRUE);
        }
        this.left = true;
    }

    private void connectRight() {
        if (isLeft()) {
            throw new IllegalArgumentException(EXCEPTION_BOTH_TRUE);
        }
        this.right = true;
    }

    public void connect(Point point) {
        connectRight();
        point.connectLeft();
    }

    public boolean isConnected() {
        return isLeft() || isRight();
    }
}
