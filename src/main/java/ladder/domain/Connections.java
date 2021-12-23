package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Connections {
    private final List<Connection> connections = new ArrayList<>();

    public Connections() {

    }

    public Connections(List<Connection> connections) {
        this.connections.addAll(connections);
    }

    public int size() {
        return connections.size();
    }
    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    public void addLine(Boolean point) {
        connections.add(new Connection(point));
    }

    public Boolean connected(int index) {
        return connections.get(index).getConnected();
    }
}
