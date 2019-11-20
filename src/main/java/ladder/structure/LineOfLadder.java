package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

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
    private List<Connection> connections;
    private List<Integer> pointsAfterConnection;

    public LineOfLadder(int ladderWidth,
                        ConnectionStrategy connectionStrategy,
                        List<Integer> pointsBeforeConnection) {
        if (pointsBeforeConnection == null) {
            pointsBeforeConnection = IntStream.rangeClosed(0, ladderWidth).boxed().collect(toList());
        }
        this.connections = new ArrayList<>();
        addConnections(ladderWidth, connectionStrategy);
        findPointsForNextLine(pointsBeforeConnection);
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public boolean isConnected(int index) {
        if (index < 0 || index >= connections.size()) {
            return false;
        }
        return connections.get(index).isConnected();
    }

    public List<Integer> getPointsAfterConnection() {
        return this.pointsAfterConnection;
    }

    private void addConnections(int ladderWidth, ConnectionStrategy connectionStrategy) {
        Connection before = null;
        for (int width = 0; width < ladderWidth; width++) {
            before = Connection.of(connectionStrategy, before);
            connections.add(before);
        }
    }

    private void findPointsForNextLine(List<Integer> nowPoints) {
        List<Integer> pointsAfterConnection = new ArrayList<>();
        for (int nowPoint : nowPoints) {
            pointsAfterConnection.add(findPointForNextLine(nowPoint));
        }
        this.pointsAfterConnection = pointsAfterConnection;
    }

    private int findPointForNextLine(int index) {
        if (isConnected(index + CONNECTION_TO_RIGHT)) {
            return index + MOVE_RIGHT;
        }
        if (isConnected(index + CONNECTION_TO_LEFT)) {
            return index + MOVE_LEFT;
        }
        return index + MOVE_STRAIGHT;
    }
}


