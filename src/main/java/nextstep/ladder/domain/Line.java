package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    public Line(final int countOfPerson) {
        this.points = createLine(countOfPerson);
    }

    private List<Boolean> createLine(final int countOfPerson) {
        // TODO 랜덤으로 boolean 값이 생성되도록?
        return Stream.generate(() -> true)
                .limit(countOfPerson)
                .collect(Collectors.toList());
    }

    public static Line valueOf(final int count) {
        return new Line(count);
    }

    public static Line valueOf(final Participants participants) {
        return new Line(participants.size());
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        final Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
