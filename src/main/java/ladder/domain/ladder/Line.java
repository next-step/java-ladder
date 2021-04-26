package ladder.domain.ladder;

import ladder.domain.participant.Participants;
import ladder.strategy.LineGenerateStrategy;
import ladder.exception.PointListNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Line {

    private static final int START_INCLUSIVE = 0;
    private static final int TWO = 2;

    private final List<Point> line;

    public static final Line of(final Participants participants, final LineGenerateStrategy strategy) {
        return of(init(participants, strategy));
    }

    public static final Line of(final List<Point> line) {
        return new Line(line);
    }

    public Line(final List<Point> line) {
        validateNull(line);
        this.line = line;
    }

    private final void validateNull(final List<Point> line) {
        if (Objects.isNull(line)) {
            throw new PointListNullPointerException();
        }
    }

    public final int move(final int position) {
        return line.get(position).move();
    }

    private static final List<Point> init(final Participants participants, final LineGenerateStrategy strategy) {
        final int countOfParticipants = participants.countOfParticipants();
        List<Point> points = new ArrayList<>();
        points.add(getFirst(strategy));
        IntStream.range(START_INCLUSIVE, countOfParticipants - TWO)
                .forEach(before -> points.add(getNext(strategy, points, before)));
        points.add(getLast(countOfParticipants, points));
        return points;
    }

    private static final Point getFirst(final LineGenerateStrategy strategy) {
        return Point.first(strategy.generate());
    }

    private static final Point getNext(final LineGenerateStrategy strategy, final List<Point> points, final int before) {
        return points.get(before).next(strategy);
    }

    private static final Point getLast(final int countOfParticipants, final List<Point> points) {
        return points.get(countOfParticipants - TWO).last();
    }

    public final Stream<Point> stream() {
        return line.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }


}
