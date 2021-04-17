package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int size, Condition condition) {
        return IntStream.range(0, size)
                .mapToObj(index -> condition.getCondition())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Line::new));
    }

    public int getSize() {
        return points.size();
    }

    public boolean getPoint(int count) {
        return this.points.get(count);
    }
}
