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
    private List<Integer> points;

    public Points(Connections connections, int ladderWidth, List<Integer> pointsBeforeConnection) {
        if (pointsBeforeConnection == null) {
            pointsBeforeConnection = IntStream.rangeClosed(0, ladderWidth).boxed().collect(toList());
        }
        findPointsForNextLine(connections, pointsBeforeConnection);
    }

    public List<Integer> getPoints() {
        return points;
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
