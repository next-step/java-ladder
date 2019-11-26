package ladder.game;

import ladder.structure.connection.Connections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private List<Point> points;

    public Points(int ladderWidth) {
        this.points = IntStream.rangeClosed(0, ladderWidth)
                .boxed()
                .map(num -> Point.of(num))
                .collect(toList());
    }

    public Points(Connections connections,
                  Points points) {
        points.findPointsForNextLine(connections, points.getPoints());
        this.points = points.getPoints();
    }

    public List<Point> getPoints() {
        return points;
    }

    private void findPointsForNextLine(Connections connections, List<Point> nowPoints) {
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point nowPoint : nowPoints) {
            pointsAfterConnection.add(findPointForNextLine(connections, nowPoint.getPoint()));
        }
        this.points = pointsAfterConnection;
    }

    private Point findPointForNextLine(Connections connections, int index) {
        if (connections.get(index + CONNECTION_TO_RIGHT).isConnected()) {
            return Point.of(index + MOVE_RIGHT);
        }
        if (connections.get(index + CONNECTION_TO_LEFT).isConnected()) {
            return Point.of(index + MOVE_LEFT);
        }
        return Point.of(index + MOVE_STRAIGHT);
    }
}
