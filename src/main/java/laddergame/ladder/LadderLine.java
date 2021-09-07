package laddergame.ladder;

import laddergame.connectable.Connectable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderLine {

    private static final int CONNECTION_START_IDX = 1;
    private final List<Connection> connections = new ArrayList<>();

    public LadderLine(int countOfPerson, Connectable connectable) {
        initConnections(countOfPerson, connectable);
    }

    private void initConnections(int countOfPerson, Connectable connectable) {
        IntStream.range(CONNECTION_START_IDX, countOfPerson)
                .forEach(i -> tryConnection(connectable));
    }

    private void tryConnection(Connectable connectable) {
        if (connections.isEmpty()) {
            connections.add(connectable.value());
            return;
        }

        if (isLatestConnected()) {
            connections.add(Connection.DISCONNECTED);
            return;
        }

        connections.add(connectable.value());
    }

    private boolean isLatestConnected() {
        return connections.get(connections.size() - 1).equals(Connection.CONNECTED);
    }

    public List<Connection> connections() {
        return this.connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
