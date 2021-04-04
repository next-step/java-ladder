package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_HEIGHT = 2;
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        valid(countOfPerson);
        IntStream.range(0, countOfPerson)
            .forEach((index) -> points.add(new Point()));
    }

    private void valid(int countOfPerson) {
        if (countOfPerson < MIN_HEIGHT) {
            throw new IllegalArgumentException("참여자의 수는 최소 2명 이상이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Line line = (Line)o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
