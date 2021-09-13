package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        validNotEmptyPoints(points);
        this.points = points;
    }

    private void validNotEmptyPoints(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("포인트 목록이 비었습니다.");
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
