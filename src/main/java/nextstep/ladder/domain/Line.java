package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validate(points);
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    public int size() {
        return this.points.size();
    }

    public boolean hasLine(int i) {
        return points.get(i);
    }

    private void validate(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1)).forEach(i -> {
            throw new IllegalArgumentException("가로선이 연속될 수 없습니다.");
        });
    }
}
