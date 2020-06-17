package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class Points {

    private static final int MINIMUM_POINT_SIZE = 2;

    private final List<Point> points;

    private Points(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    public static Points newInstance(List<Point> points) {
        return new Points(points);
    }

    private void validate(List<Point> points) {
        if (Objects.isNull(points)) {
            throw new IllegalArgumentException("argument points is null");
        }
        if (points.size() < MINIMUM_POINT_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POINT_SIZE + "입니다.");
        }
    }
}
