package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Bar;
import nextstep.ladder.domain.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {

    private final Bars bars;

    public Line(Bar... bars) {
        this(Arrays.asList(bars));
    }

    public Line(List<Bar> bars) {
        this.bars = Bars.valueOf(bars);
    }

    public static Line valueOf(Bar... bars) {
        return new Line(bars);
    }

    public static Line valueOf(List<Bar> bars) {
        return new Line(bars);
    }

    public Bars points() {
        return bars;
    }

    public Position move(final Position userPosition) {
        return bars.move(userPosition);
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
