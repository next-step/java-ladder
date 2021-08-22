package ladder.domain;

import ladder.exception.InvalidInputException;
import ladder.exception.LadderException;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final String INVALID_HEIGHT_MESSAGE = "2 이상의 높이를 입력해주세요";

    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);

        IntStream.range(1, countOfPerson)
                 .forEach(point -> points.add(PointStrategy.generate(points.get(point - 1))));

        this.points = points;
    }

    public static Line of(int height) {
        if (height < 2) {
            throw new InvalidInputException(INVALID_HEIGHT_MESSAGE);
        }

        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, height)
                 .forEach(point -> points.add(false));

        return new Line(points);
    }


    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
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