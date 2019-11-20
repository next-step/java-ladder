package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.Connections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LineOfLadder {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;
    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;
    private Connections connections;
    private List<Integer> pointsAfterConnection;

    public LineOfLadder(int ladderWidth,
                        ConnectionStrategy connectionStrategy,
                        List<Integer> pointsBeforeConnection) {
        if (pointsBeforeConnection == null) {
            pointsBeforeConnection = IntStream.rangeClosed(0, ladderWidth).boxed().collect(toList());
        }
        this.connections = new Connections(ladderWidth, connectionStrategy);
        findPointsForNextLine(pointsBeforeConnection);
    }

    public List<Connection> getConnections() {
        return connections.getConnections();
    }

    public List<Integer> getPointsAfterConnection() {
        return this.pointsAfterConnection;
    }

    private void findPointsForNextLine(List<Integer> nowPoints) {
        List<Integer> pointsAfterConnection = new ArrayList<>();
        for (int nowPoint : nowPoints) {
            pointsAfterConnection.add(findPointForNextLine(nowPoint));
        }
        this.pointsAfterConnection = pointsAfterConnection;
    }

    private int findPointForNextLine(int index) {
        if (connections.get(index + CONNECTION_TO_RIGHT).isConnected()) {
            return index + MOVE_RIGHT;
        }
        if (connections.get(index + CONNECTION_TO_LEFT).isConnected()) {
            return index + MOVE_LEFT;
        }
        return index + MOVE_STRAIGHT;
    }
}


