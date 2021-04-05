package nextstep.ladder.domain;

import nextstep.ladder.generator.DefaultLineGenerator;
import nextstep.ladder.generator.LineGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static nextstep.ladder.domain.Position.MOVABLE_COUNT;

public class Line {

    private final List<Point> points;

    private Line(final int countOfPerson) {
        this(countOfPerson, new DefaultLineGenerator());
    }

    private Line(final int countOfPerson, final LineGenerator generator) {
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

    public Position move(final Position userPosition) {
        int currentPosition = userPosition.currentPosition();

        if(isMoveLeft(currentPosition)) {
            return userPosition.left();
        }
        if(isMoveRight(currentPosition)) {
            return userPosition.right();
        }
        return userPosition;
    }

    private boolean isMoveRight(final int currentPosition) {
        int nextPosition = currentPosition + MOVABLE_COUNT;
        return isLadderBound(nextPosition)
                && points.get(nextPosition).isExist();
    }

    private boolean isLadderBound(final int nextPosition) {
        return nextPosition < points.size();
    }

    private boolean isMoveLeft(final int currentPosition) {
        return points.get(currentPosition).isExist();
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
