package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final String EXIST_POINT_STR = "-----";
    private static final String EMPTY_POINT_STR = "     ";
    private static final String DELIMITER_STR = "|";
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int width, CreateStrategy strategy) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);

        for (int i = 1; i < width; i++) {
            final boolean create = strategy.isCreate(points.get(i - 1));
            points.add(create);
        }

        this.points = points.subList(1, width);
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
        return this.points.stream()
                .map(this::getRadderStr)
                .collect(Collectors.joining(DELIMITER_STR, DELIMITER_STR, DELIMITER_STR));
    }
}
