package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Ladder.LADDER_POLE;

public class Points {

    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public int move(int currentPoint) {
        return points.get(currentPoint).move();
    }

    @Override
    public String toString() {
        return IntStream.range(0, points.size() - 1)
            .boxed()
            .map(i -> points.get(i).toString())
            .collect(Collectors.joining(LADDER_POLE));
    }
}
