package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line (List<Boolean> points) {
        this.validate(points);
        this.points = new ArrayList<>(points);
    }

    public void validate(List<Boolean> points) {
        checkMoreThanTwoLinesAttached(points);
    }

    private void checkMoreThanTwoLinesAttached(List<Boolean> points) {
        boolean thisLineHasPoint = false;
        boolean nextLineHasPoint = false;
        for (int i = 0; i < points.size() - 1; i++) {
            thisLineHasPoint = points.get(i);
            nextLineHasPoint = points.get(i + 1);
            if (thisLineHasPoint && nextLineHasPoint) {
                throw new IllegalArgumentException("사다리는 가로 라인이 겹칠 수 없습니다.");
            }
        }
    }

    public List<Boolean> points() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
