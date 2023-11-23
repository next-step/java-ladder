package nextstep.step4.domain;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(final int index) {
        final Point point = this.points.get(index);
        final MoveDirection moveDirection = point.move();

        return moveDirection.move(index);
    }
}
