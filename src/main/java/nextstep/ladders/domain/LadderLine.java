package nextstep.ladders.domain;

import nextstep.ladders.domain.strategy.DirectionGenerator;
import nextstep.ladders.exception.InvalidLineSizeException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(final List<Point> points) {
        this.points = points;
    }

    public LadderLine(final DirectionGenerator directionGenerator, final int numberOfPeople) {
        this(Point.toList(directionGenerator, numberOfPeople));
    }

    public static List<LadderLine> toList(final DirectionGenerator directionGenerator, final int height, final int numberOfPeople) {
        return Stream.generate(() -> new LadderLine(directionGenerator, numberOfPeople))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int move(final int index) {
        checkValidIndex(index);
        Point point = points.get(index);
        return point.move();
    }

    private void checkValidIndex(final int index) {
        if (index < 0 || index >= points.size()) {
            throw new InvalidLineSizeException();
        }
    }

    public List<Point> elements() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine ladderLine = (LadderLine) o;
        return Objects.equals(points, ladderLine.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
