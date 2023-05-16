package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = valid(points);
    }

    public static Line of(LineStrategy lineStrategy, int countOfPerson) {
        return new Line(lineStrategy.listSizeOf(countOfPerson - 1));
    }

    public List<Boolean> points() {
        return List.copyOf(points);
    }

    public int length() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    private List<Boolean> valid(List<Boolean> points) {
        if (isNullOrEmpty(points)) {
            throw new IllegalArgumentException("라인은 빈 값일 수 없습니다.");
        }
        return overlappingRemovedList(points);
    }

    private List<Boolean> overlappingRemovedList(List<Boolean> points) {
        List<Boolean> ret = new ArrayList<>(points);
        for (int i = 1; i < ret.size() ; i++) {
            ret.set(i, unOverlappedPoint(ret, i));
        }
        return ret;
    }

    private Boolean unOverlappedPoint(List<Boolean> points, int i) {
        return isOverlapping(points, i) ? Boolean.FALSE : points.get(i);
    }

    private boolean isOverlapping(List<Boolean> points, int i) {
        return i != 0 && points.get(i - 1).equals(Boolean.TRUE) && points.get(i).equals(Boolean.TRUE);
    }

    private boolean isNullOrEmpty(List<Boolean> points) {
        return points == null || points.isEmpty();
    }

}
