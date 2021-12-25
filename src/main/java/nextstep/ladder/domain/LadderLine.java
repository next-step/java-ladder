package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.RailCount;

public class LadderLine implements Line {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static LadderLine init(RailCount ladderRailCount, LadderPointGenerateStrategy strategy) {
        return new LadderLine(LadderLineBuilder.of(ladderRailCount, strategy).build());
    }

    public static LadderLine init(int railCount, LadderPointGenerateStrategy strategy) {
        return new LadderLine(LadderLineBuilder.of(LadderRailCount.of(railCount), strategy).build());
    }

    public Index move(int position) {
        return points.get(position).move();
    }

    @Override
    public Stream<Boolean> boolStream() {
        return points.stream()
                .map(Point::isRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}