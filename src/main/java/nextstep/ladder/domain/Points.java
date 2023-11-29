package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Direction.*;
import static nextstep.ladder.domain.Ladder.LADDER_POLE;

public class Points {
    public static final String TRUE_BRIDGE = "-----";
    public static final String FALSE_BRIDGE = "     ";

    private List<Point> points;

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
            .map(i -> drawLadder(points.get(i).direction()))
            .collect(Collectors.joining(LADDER_POLE));
    }

    private String drawLadder(Direction direction) {
        if (LEFT.equals(direction) || CENTER.equals(direction)) {
            return FALSE_BRIDGE;
        }

        return TRUE_BRIDGE;
    }
}
