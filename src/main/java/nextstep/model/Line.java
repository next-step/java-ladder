package nextstep.model;

import java.util.Objects;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;
import static nextstep.constant.Constant.HORIZON_LADDER_STRING;

public class Line {
    private final Points points;

    public Line (int countOfPerson) {
        this.points = new Points(countOfPerson);
    }

    public void markOne(int target) {
        points.markOne(target, true);
    }


    public void markRandom() {
        this.points.markRandom();
    }

    public void markRandom(Line line) {
        this.points.markBottom(line.getPoints());
    }


    public Points getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
