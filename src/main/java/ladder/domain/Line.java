package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Stick> sticks;

    public Line(final List<Stick> sticks) {
        this.sticks = sticks;
    }

    public static Line of(final LadderHeight ladderHeight, final DetermineStick determineStick) {
        List<Stick> sticks = IntStream.range(0, ladderHeight.getValue())
                .mapToObj(height -> new Stick(determineStick))
                .collect(Collectors.toList());
        return new Line(sticks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(sticks, line.sticks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sticks);
    }

    @Override
    public String toString() {
        return "Line{" +
                "sticks=" + sticks +
                '}';
    }
}
