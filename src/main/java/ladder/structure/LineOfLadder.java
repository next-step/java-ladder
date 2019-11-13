package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LineOfLadder {
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_STRAIGHT = 0;
    private static final int MOVE_LEFT = -1;

    private static final int CONNECTION_TO_RIGHT = 0;
    private static final int CONNECTION_TO_LEFT = -1;


    private List<Boolean> connections;

    public LineOfLadder(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.connections = new ArrayList<>();
        createLine(ladderWidth, connectionStrategy);
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    private void createLine(int ladderWidth, ConnectionStrategy connectionStrategy) {
        for (int width = 0; width < ladderWidth; width++) {
            connections.add(createConnection(connectionStrategy));
        }
    }

    private boolean createConnection(ConnectionStrategy connectionStrategy) {
        int connectedCount = connections.size();
        if (connectedCount != 0 && connections.get(connectedCount - 1)) {
            return false;
        }
        return connectionStrategy.create();
    }

    public List<Integer> findPointsForNextLine(List<Integer> nowPoints) {
        if (nowPoints == null) {
            nowPoints = IntStream.rangeClosed(0, connections.size()).boxed().collect(toList());
        }

        List<Integer> nextPoints = new ArrayList<>();
        for (int nowPoint : nowPoints) {
            nextPoints.add(findPointForNextLine(nowPoint));
        }
        return nextPoints;
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

    private boolean isConnected(int index) {
        if (index < 0 || index >= connections.size()) {
            return false;
        }
        return connections.get(index);
    }


}


