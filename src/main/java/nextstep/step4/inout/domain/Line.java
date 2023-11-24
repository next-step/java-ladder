package nextstep.step4.inout.domain;

import java.util.ArrayList;
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

    public List<Boolean> getHasRungs() {
        List<Boolean> hasRungs = new ArrayList<>();

        for (int idx = 0; idx < this.points.size() - 1; idx++) {
            final Point point = this.points.get(idx);

            hasRungs.add(point.hasRightRung());
        }

        return hasRungs;
    }
}
