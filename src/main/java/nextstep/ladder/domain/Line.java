package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        validateSidePoint(points);

        this.points = points;
    }

    private void validateSidePoint(List<Point> points) {
        if (!(points.get(0) instanceof LeftSidePoint)) {
            throw new IllegalArgumentException("Line 규칙에 위반되었습니다. 첫 번째는 항상 LeftSidePoint여야 합니다.");
        }

        if (!(points.get(points.size() - 1) instanceof RightSidePoint)) {
            throw new IllegalArgumentException("Line 규칙에 위반되었습니다. 마지막 항상 RightSidePoint여야 합니다.");
        }
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public int getDestinationFrom(int departPosition) {
        return departPosition + this.points.get(departPosition).getDirection();
    }

    public int size() {
        return this.points.size();
    }
}
