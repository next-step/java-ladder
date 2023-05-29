package ladder.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(List<Boolean> values) {
        values.forEach(value -> points.add(new Point(value)));
    }

    public Line(int countOfPerson) {
        if (countOfPerson <= 0) {
            throw new IllegalArgumentException("양수여야 합니다.");
        }

        this.points.add(new Point());
        for (int idx = 1; idx < countOfPerson - 1 ; idx++) {
            addNewPoint(idx);
        }
    }

    private void addNewPoint(int idx) {
        if (validateBeforeIdxHasTrue(idx)) {
            this.points.add(new Point(false));
            return;
        }
        this.points.add(new Point());
    }

    public boolean validateBeforeIdxHasTrue(int idx) {
        if (idx <= 0) {
            return false;
        }

        return this.points.get(idx - 1).isTrue();
    }

    public Point getPoint(int idx) {
        return this.points.get(idx);
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public int getLineSize() {
        return this.points.size();
    }
}
