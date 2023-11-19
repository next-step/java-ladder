package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        connectedLegCheck(points);
        this.points = points;
    }

    public List<Boolean> points() {
        return points;
    }

    private void connectedLegCheck(List<Boolean> points) {
        points.stream().reduce((first, second) -> {
            if (first && second) {
                throw new IllegalArgumentException("연속된 사다리는 생성할 수 없습니다.");
            }
            return second;
        });
    }
}
