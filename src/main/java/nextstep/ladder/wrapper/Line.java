package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Bar;
import nextstep.ladder.domain.Position;
import nextstep.ladder.generator.DefaultLineGenerator;
import nextstep.ladder.generator.LineGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static nextstep.ladder.domain.Position.MOVABLE_COUNT;

public class Line {

    private final List<Bar> bars;

    private Line(final int countOfPerson) {
        this(countOfPerson, new DefaultLineGenerator());
    }

    private Line(final int countOfPerson, final LineGenerator generator) {
        this.bars = generator.createLine(countOfPerson);
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

    public List<Bar> points() {
        return Collections.unmodifiableList(bars);
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
                && bars.get(nextPosition).isExist();
    }

    private boolean isLadderBound(final int nextPosition) {
        return nextPosition < bars.size();
    }

    private boolean isMoveLeft(final int currentPosition) {
        return bars.get(currentPosition).isExist();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        final Line line = (Line) o;
        return Objects.equals(bars, line.bars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bars);
    }

    @Override
    public String toString() {
        return String.valueOf(bars);
    }
}
