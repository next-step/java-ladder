package ladder.structure.connection.result;

import ladder.structure.connection.Connections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private final List<Point> points;

    public Points(int ladderWidth) {
        this.points = IntStream.rangeClosed(0, ladderWidth)
                .boxed()
                .map(Point::of)
                .collect(toList());
    }

    private Points(List<Point> points) {
        this.points = points;
    }

    public Points move(Connections connections) {
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point before : points) {
            Point after = before.move(
                    connections.isConnected(before.value() + CONNECTION_TO_LEFT),
                    connections.isConnected(before.value() + CONNECTION_TO_RIGHT)
            );
            pointsAfterConnection.add(after);
        }
        return new Points(Collections.unmodifiableList(pointsAfterConnection));
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
