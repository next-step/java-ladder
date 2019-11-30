package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private final List<Point> points;

    private Points(List<Point> points, MoveStrategy moveStrategy) {
        this.points = points;
        setDirections(moveStrategy);
    }

    public Points(int ladderWidth, MoveStrategy moveStrategy) {
        this(IntStream.rangeClosed(0, ladderWidth).boxed()
                .map(Point::of)
                .collect(toList()), moveStrategy);
    }

    private void setDirections(MoveStrategy moveStrategy) {
        this.points.stream().sorted(Point::compare)
                .reduce(null, (a, b) -> b.setDirection(a, moveStrategy))
                .setDirectionOfLast();
    }

    public Points getNext(MoveStrategy moveStrategy) {
        List<Point> pointsAfterMove = new ArrayList<>();
        for (Point before : points) {
            Point after = before.move();
            pointsAfterMove.add(after);
        }
        return new Points(pointsAfterMove, moveStrategy);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
