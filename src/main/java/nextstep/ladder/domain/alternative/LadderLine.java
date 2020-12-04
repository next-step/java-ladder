package nextstep.ladder.domain.alternative;

import nextstep.ladder.domain.BooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static nextstep.ladder.domain.BooleanGenerator.generateBooleans;

public class LadderLine {
    private static final Random RANDOM = new Random();
    private final List<Point> points;

    LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int size) {
        return of(size, RANDOM::nextBoolean);
    }

    static LadderLine of(int size, BooleanGenerator generator) {
        return new LadderLine(new PointListBuilder(
                generateBooleans(excludeFirstPoint(size), generator)).build());
    }

    private static int excludeFirstPoint(int size) {
        return size - 1;
    }

    int sizeOfPoints() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LadderLine that = (LadderLine) o;
        return points.equals(that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Boolean> toMovableList() {
        return points.stream()
                .limit(points.size() - 1)
                .map(Point::hasRight)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }
}
