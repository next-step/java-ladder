package nextstep.ladder.domain;

import java.util.List;

public class Points {
    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public boolean isConsecutiveAt(int position) {
        if (position < 0 || position >= points.size()) {
            throw new RuntimeException("범위를 벗어나는 위치입니다.");
        }
        return points.get(position).isPresent() && points.get(position + 1).isPresent();
    }
}
