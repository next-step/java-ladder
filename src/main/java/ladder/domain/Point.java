package ladder.domain;

import static ladder.domain.Direction.*;

public class Point {
    private static final int DISTANCE_FROM_NEXT_POINT = 1;
    private static final int DISTANCE_FROM_SELF = 0;

    private final int position;
    private Direction direction = DOWN;

    private Point(int position) {
        this.position = position;
    }

    public static Point in(int position) {
        return new Point(position);
    }

    public void connect(Point other) {
        int distanceToOther = this.position - other.position;

        if (Math.abs(distanceToOther) > DISTANCE_FROM_NEXT_POINT || distanceToOther == DISTANCE_FROM_SELF) {
            throw new IllegalArgumentException("바로 옆에 있는 점만 연결 가능하다");
        }

        if (!(this.isConnectedTo(DOWN) && other.isConnectedTo(DOWN))) {
            throw new IllegalArgumentException("양 옆으로 연결이 되어 있지 않은 점들끼리만 연결 가능하다");
        }

        connect(other, distanceToOther);
    }

    public boolean isConnectedTo(Direction direction) {
        return this.direction == direction;
    }

    public boolean existConnect() {
        return !this.isConnectedTo(DOWN);
    }

    private void connect(Point other, int distance) {
        if (distance > 0) {
            other.direction = RIGHT;
            this.direction = LEFT;
            return;
        }

        other.direction = LEFT;
        this.direction = RIGHT;
    }
}
