package nextstep.ladder.domain;

import nextstep.ladder.generator.DefaultLineGenerator;
import nextstep.ladder.generator.LineGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points;

    public Line(final int countOfPerson) {
        this(countOfPerson, new DefaultLineGenerator());
    }

    public Line(final int countOfPerson, final LineGenerator generator) {
        this.points = generator.createLine(countOfPerson);
    }

    public static Line valueOf(final int count) {
        return new Line(count);
    }

    public static Line valueOf(final int count, final LineGenerator generator) {
        return new Line(count, generator);
    }

    public static Line valueOf(final Participants participants) {
        return new Line(participants.size());
    }

    public static Line valueOf(final Participants participants, final LineGenerator generator) {
        return new Line(participants.size(), generator);
    }

    public List<Point> points() {
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
