package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import ladder.exception.MinimumParticipantException;

public class Line {
    private static final int MIN_PERSON = 2;

    private final List<Point> line = new ArrayList<>();

    public Line(int countOfPerson, ConnectStrategy connectStrategy) {
        validate(countOfPerson);
        create(countOfPerson, connectStrategy);
    }

    private void validate(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new MinimumParticipantException("참여자의 수는 최소 " + MIN_PERSON + "명 이상이여야 합니다.");
        }
    }

    private void create(int countOfPerson, ConnectStrategy connectStrategy) {
        line.add(Point.from(false));

        IntStream.range(0, countOfPerson - 1)
            .forEach((index) -> {
                line.add(Point.from(connectStrategy.connectable(line.get(index).toBoolean())));
            });
    }

    private Point connect(int index, boolean connectable) {
        if (line.get(index).toBoolean()) {
            return Point.from(false);
        }
        return Point.from(connectable);
    }

    public List<Point> getPoint() {
        return Collections.unmodifiableList(this.line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Line line1 = (Line)o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
