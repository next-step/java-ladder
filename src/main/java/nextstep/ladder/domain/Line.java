package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String EXIST_POINT_STR = "|-----";
    private static final String EMPTY_POINT_STR = "|     ";
    private static final String END_STR = "|";
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int countOfPerson, CreateStrategy strategy) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, countOfPerson - 1)
        .forEach(i -> {
            boolean shouldCreate = strategy.isCreate() && (i == 0 || !points.get(i - 1));
            points.add(shouldCreate);
        });

        this.points = points;
    }

    private String getRadderStr(boolean point) {
        if (point) {
            return EXIST_POINT_STR;
        }

        return EMPTY_POINT_STR;
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
        List<String> pointStrList = this.points.stream()
                .map(this::getRadderStr)
                .collect(Collectors.toList());
        return String.join("", pointStrList) + END_STR;
    }
}
