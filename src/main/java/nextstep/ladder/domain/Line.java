package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    public Line (int countOfMember, PointStrategy pointStrategy) {
        List<Boolean> booleans = new ArrayList<>();
        for (int i=0; i < countOfMember; i++) {
            if(i == 0) {
                booleans.add(false);
            }else {
                booleans.add(isPrevLined(pointStrategy, booleans.get(i-1)));
            }
        }
        this.points = booleans;
    }

    private boolean isPrevLined(PointStrategy pointStrategy, boolean prevLined) {
        if(prevLined) {
            return false;
        }
        return pointStrategy.generate();
    }

    public List<Boolean> getPoints() {
        return points;
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
