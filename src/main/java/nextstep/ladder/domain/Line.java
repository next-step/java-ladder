package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(final int countOfPerson) {
        this.points = createLine(countOfPerson);
    }

    private List<Boolean> createLine(final int countOfPerson) {
        return IntStream.rangeClosed(0, countOfPerson)
                .mapToObj(value -> true)
                .collect(Collectors.toList());
    }

    public static Line valueOf(final int count) {
        return new Line(count);
    }

    public static Line valueOf(final Participants participants) {
        return new Line(participants.size());
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
