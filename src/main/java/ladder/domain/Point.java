package ladder.domain;

import static ladder.domain.Direction.*;

public class Point {
    private final int position;
    private Direction direction = DOWN;

    private Point(int position) {
        this.position = position;
    }

    public static Point in(int position) {
        return new Point(position);
    }

    public void connect(Point other) {
        int distance = this.position - other.position;

        if (Math.abs(distance) >  1 || distance == 0) {
            throw new IllegalArgumentException("바로 옆에 있는 점만 연결 가능하다");
        }

        if (!(this.isConnectedTo(DOWN) && other.isConnectedTo(DOWN))) {
            throw new IllegalArgumentException("양 옆으로 연결이 되어 있지 않은 점들끼리만 연결 가능하다");
        }

        connect(other, distance);
    }

    public boolean isConnectedTo(Direction direction) {
        return this.direction == direction;
    }

    private void connect(Point other, int distance) {
        if (distance == 1) {
            other.direction = RIGHT;
            this.direction = LEFT;
            return;
        }

        other.direction = LEFT;
        this.direction = RIGHT;
    }
}
