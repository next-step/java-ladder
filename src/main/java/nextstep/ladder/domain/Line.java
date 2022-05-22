package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public static Line init(Height height) {
        if (height == null) {
            throw new LadderException(LadderExceptionCode.INVALID_HEIGHT);
        }
        return new Line(
                IntStream.range(0, height.getHeight())
                        .mapToObj(i -> Boolean.FALSE)
                        .collect(Collectors.toList())
        );
    }

    Line(List<Boolean> points) {
        this.points = points;
    }

    public void createWith(Line compare) {
        points = compare.getPoints()
                .stream()
                .map(this::calculate)
                .collect(Collectors.toList());
    }

    private Boolean calculate(Boolean comparedPoint) {
        return comparedPoint ? false : randomBoolean();
    }

    private boolean randomBoolean() {
        boolean[] booleans = new boolean[]{false, true, true};
        return booleans[new Random().nextInt(3)];
    }

    public Boolean point(int index) {
        return getPoints().get(index);
    }

    private List<Boolean> getPoints() {
        return points;
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

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
