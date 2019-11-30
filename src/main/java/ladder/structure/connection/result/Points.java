package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private final List<Point> points;

    public Points(int participantsSize, MoveStrategy moveStrategy) {
        this.points = createPoints(participantsSize, moveStrategy);
    }

    private List<Point> createPoints(int participantsSize, MoveStrategy moveStrategy) {
        List<Point> points = new ArrayList<>();

        List<Integer> withoutLast = IntStream.range(0, participantsSize - 1).boxed().collect(toList());
        boolean lastConnection = withoutLast.stream()
                .reduce(false, (a, b) -> {
                    Point now = Point.of(a, moveStrategy);
                    points.add(now);
                    return now.camMoveRight();
                }, (a, b) -> {
                    Point now = Point.of(a, moveStrategy);
                    return now.camMoveRight();
                });

        Point last = Point.lastOf(lastConnection);
        points.add(last);
        return points;
    }

    public List<Integer> getNext(List<Integer> now) {
        if (now == null) {
            now = IntStream.range(0, points.size()).boxed()
                    .collect(Collectors.toList());
        }
        return now.stream()
                .map(num -> num + points.get(num).getDirection().getNum())
                .collect(Collectors.toList());
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
