package ladder.game;

import ladder.structure.connection.Connections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private List<Integer> points;

    public Points(int ladderWidth) {
        this.points = IntStream.rangeClosed(0, ladderWidth)
                .boxed().collect(toList());
    }

    public Points(Connections connections,
                  Points points) {
        points.findPointsForNextLine(connections, points.getPoints());
        this.points = points.getPoints();
    }

    public List<Integer> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private void findPointsForNextLine(Connections connections, List<Integer> nowPoints) {
        List<Integer> pointsAfterConnection = new ArrayList<>();
        for (int nowPoint : nowPoints) {
            pointsAfterConnection.add(findPointForNextLine(connections, nowPoint));
        }
        this.points = pointsAfterConnection;
    }

    private int findPointForNextLine(Connections connections, int index) {
        if (connections.get(index + CONNECTION_TO_RIGHT).isConnected()) {
            return index + MOVE_RIGHT;
        }
        if (connections.get(index + CONNECTION_TO_LEFT).isConnected()) {
            return index + MOVE_LEFT;
        }
        return index + MOVE_STRAIGHT;
    }
}
