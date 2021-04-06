package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_PERSON = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, ConnectStrategy connectStrategy) {
        validate(countOfPerson);
        create(countOfPerson, connectStrategy);
    }

    private void validate(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException("참여자의 수는 최소 " + MIN_PERSON + "명 이상이여야 합니다.");
        }
    }

    private void create(int countOfPerson, ConnectStrategy connectStrategy) {
        points.add(Point.DISCONNECT);

        IntStream.range(0, countOfPerson - 1)
            .forEach((index) -> {
                points.add(connect(index, connectStrategy.connectable()));
            });
    }

    private Point connect(int index, boolean connectable) {
        if (points.get(index).getConnection()) {
            return Point.DISCONNECT;
        }
        return Point.from(connectable);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(this.points);
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
