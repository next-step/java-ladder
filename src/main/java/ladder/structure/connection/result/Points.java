package ladder.structure.connection.result;

import ladder.structure.connection.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private final List<Point> points;

    public Points(int ladderWidth, MoveStrategy moveStrategy) {
        this.points = IntStream.rangeClosed(0, ladderWidth).boxed()
                .map(Point::of)
                .collect(toList());
        setDirections(moveStrategy);
    }

    private Points(List<Point> points, MoveStrategy moveStrategy) {
        this.points = points;
        setDirections(moveStrategy);
    }

    private void setDirections(MoveStrategy moveStrategy) {
        Map<Integer, Point> pointByColumn = this.points.stream()
                .collect(Collectors.toMap(Point::getColumn, point -> point));

        Point now = pointByColumn.get(0);
        now.setDirection(moveStrategy);
        Point before = now;
        for (int i = 1; i < points.size() - 1; i++) {
            now = pointByColumn.get(i);
            now.setDirection(before, moveStrategy);
            before = now;
        }
        pointByColumn.get(points.size() - 1).setDirectionOfLast(before);
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
