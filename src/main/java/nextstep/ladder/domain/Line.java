package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int BEGIN_INDEX = 0;
    private static final boolean EMPTY_POINT = false;
    private static final double HALF = 0.5;

    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this.points = generateLine(countOfPerson);
    }

    public Line(List<Boolean> mockPoints) {
        this.points = mockPoints;
    }

    public List<Boolean> generateLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(BEGIN_INDEX, countOfPerson)
                .forEach(idx -> points.add(createPoint(idx, points)));

        return points;
    }

    private Boolean createPoint(int idx, List<Boolean> points) {
        if (BEGIN_INDEX == idx) {
            return EMPTY_POINT;
        }
        return isPrevPointEmpty(idx, points) && isCurrPointNonEmpty();
    }

    private boolean isPrevPointEmpty(int idx, List<Boolean> points) {
        return EMPTY_POINT == points.get(idx - 1);
    }

    private boolean isCurrPointNonEmpty() {
        return HALF < Math.random();
    }

    public List<Boolean> points() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
