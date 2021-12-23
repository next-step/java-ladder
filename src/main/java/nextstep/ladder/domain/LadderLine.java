package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public Index move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(RailCount railCount, LadderPointGenerateStrategy strategy) {
        return new LadderLine(LadderLineBuilder.of(railCount, strategy).build());
    }

    public static LadderLine init(int railCount, LadderPointGenerateStrategy strategy) {
        return new LadderLine(LadderLineBuilder.of(RailCount.of(railCount), strategy).build());
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