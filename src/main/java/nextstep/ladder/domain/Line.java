package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line from(List<Boolean> points) {
        validatePoint(points);
        return new Line(points);
    }

    private static void validatePoint(List<Boolean> points) {
        Boolean prevPoint = points.get(0);

        for (int i = 1; i < points.size(); i++) {
            Boolean currPoint = points.get(i);
            if (prevPoint && currPoint) {
                throw new IllegalArgumentException("사다리 선은 이어질 수 없습니다.");
            }
            prevPoint = currPoint;
        }
    }

    public Position move(Position position) {
        if (position.canGoRight(size()) && hasPoint(position)) {
            position = position.toRight();
        } else if (position.canGoLeft() && hasPoint(position)) {
            position = position.toLeft();
        }

        return position;
    }

    public boolean hasPoint(Position position) {
        return Boolean.TRUE == points.get(position.currentPosition());
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> points() {
        return points;
    }


}
