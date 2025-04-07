package nextstep.ladder.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestPointStrategy implements PointStrategy {
    private final Queue<Boolean> points;

    public TestPointStrategy(List<Boolean> points) {
        this.points = new LinkedList<>(points);
    }

    @Override
    public boolean generate() {
        return !points.isEmpty() && points.poll();
    }
}

