package ladder.domain;

import ladder.domain.exception.DifferentLineSizeException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Stick> sticks;

    public Line(final List<Stick> sticks) {
        this.sticks = sticks;
    }

    public static Line from(final List<Boolean> values) {
        List<Stick> sticks = values.stream().map(Stick::new).collect(Collectors.toList());
        return new Line(sticks);
    }

    public static Line of(final LadderHeight ladderHeight, final DetermineStick determineStick) {
        List<Stick> sticks = IntStream.range(0, ladderHeight.getValue())
                .mapToObj(height -> new Stick(determineStick))
                .collect(Collectors.toList());
        return new Line(sticks);
    }

    public List<Integer> findIndexesBothTrue(Line line) {
        if (findHeight() != line.findHeight()) {
            throw DifferentLineSizeException.getInstance();
        }
        return IntStream.range(0, findHeight())
                .filter(index -> findStick(index).isTrueAndSo(line.findStick(index)))
                .boxed()
                .collect(Collectors.toList());
    }

    public int findHeight() {
        return sticks.size();
    }

    private Stick findStick(int index) {
        return sticks.get(index);
    }

    public Stick findStickOf(int height) {
        return sticks.get(height);
    }

    public List<Stick> getSticks() {
        return Collections.unmodifiableList(sticks);
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
