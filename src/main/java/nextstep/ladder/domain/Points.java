package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    public static final String LADDER_POLE = "|";

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
            .collect(Collectors.joining(LADDER_POLE, LADDER_POLE, LADDER_POLE));
    }
}
