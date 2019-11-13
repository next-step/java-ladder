package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LineOfLadder {
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

    public List<Integer> findNextPoints(List<Integer> nowPoints) {
        if (nowPoints == null) {
            nowPoints = IntStream.rangeClosed(0, connections.size()).boxed().collect(toList());
        }

        List<Integer> nextPoints = new ArrayList<>();
        for (int nowPoint : nowPoints) {
            nextPoints.add(findNextPoint(nowPoint));
        }
        return nextPoints;
    }

    private int findNextPoint(int index) {
        if (index == 0) {
            if (connections.get(index)) {
                return index + 1;
            } else {
                return index;
            }
        } else if (index == connections.size()) {
            if (connections.get(index - 1)) {
                return index - 1;
            } else {
                return index;
            }
        } else {
            if (connections.get(index)) {
                return index + 1;
            } else if (connections.get(index - 1)) {
                return index - 1;
            } else {
                return index;
            }
        }
    }
}


