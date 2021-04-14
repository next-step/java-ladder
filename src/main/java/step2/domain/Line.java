package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    public static final String LADDER_MOVE = "|-----";
    public static final String LADDER_STOP = "|     ";

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return points
                .stream()
                .map(point -> point ? LADDER_MOVE : LADDER_STOP)
                .collect(Collectors.joining());
    }
}
