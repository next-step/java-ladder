package nextstep.ladder.module;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<PointX> points;

    public Line(List<PointX> points) {
        Collections.sort(points);
        validate(points);
        this.points = points;
    }

    public List<PointX> value() {
        return points;
    }

    private void validate(List<PointX> points) {
        int start = points.get(0).value();
        int end = points.get(points.size() - 1).value();
        if (start != 0 || end != points.size() - 1) {
            throw new IllegalArgumentException("Line의 시작과 끝은 0과 (n-1)이어야 합니다.");
        }
    }

}
