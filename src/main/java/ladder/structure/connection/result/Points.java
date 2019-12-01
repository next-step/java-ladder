package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private final List<Point> points;

    public Points(int participantsSize, MoveStrategy moveStrategy) {
        this.points = createPoints(participantsSize, moveStrategy);
    }

    private List<Point> createPoints(int participantsSize, MoveStrategy moveStrategy) {
        List<Point> points = new ArrayList<>();

        Point now = Point.of(false, moveStrategy);
        points.add(now);
        Point before = now;
        for (int i = 1; i < participantsSize - 1; i++) {
            now = Point.of(before.isRightOpened(), moveStrategy);
            points.add(now);
            before = now;
        }
        now = Point.lastOf(before.isRightOpened());
        points.add(now);

        return points;
    }

    public List<Integer> moveNext(List<Integer> now) {
        if (now == null) {
            now = IntStream.range(0, points.size()).boxed()
                    .collect(Collectors.toList());
        }
        return now.stream()
                .map(num -> points.get(num).getNextIndex(num))
                .collect(Collectors.toList());
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
