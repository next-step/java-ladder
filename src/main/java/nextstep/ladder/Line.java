package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int width) {
        points = generatePoints(width);
    }

    private List<Boolean> generatePoints(int width) {
        return IntStream.rangeClosed(1, width - 1)
                .mapToObj(i -> true)
                .collect(Collectors.toList());
    }

    public int size() {
        return points.size();
    }
}
