package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Line implements Iterable<Boolean> { // 가로 축
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public Iterator<Boolean> iterator() {
        return points.iterator();
    }
}
