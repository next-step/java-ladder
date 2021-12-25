package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import nextstep.ladder.engine.FirstClassList;
import nextstep.ladder.engine.Line;
import nextstep.ladder.engine.RailCount;

public class LadderLine extends FirstClassList<Point> implements Line {
    public LadderLine(List<Point> points) {
        super(points);
    }

    public static LadderLine of(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("points cannot be null.");
        }

        if (points.size() < RailCount.MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("number of points must be larger than or equal to 2");
        }

        return new LadderLine(points);
    }

    public Index move(int position) {
        return elementOf(position).move();
    }

    @Override
    public Index move(Index position) {
        return elementOf(position.toInt()).move();
    }

    @Override
    public Stream<Boolean> boolStream() {
        return stream()
                .map(Point::isRight);
    }
}