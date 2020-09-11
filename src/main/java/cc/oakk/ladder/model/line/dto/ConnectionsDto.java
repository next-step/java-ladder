package cc.oakk.ladder.model.line.dto;

import cc.oakk.ladder.model.line.Connection;

import java.util.List;
import java.util.Objects;

public class ConnectionsDto {
    private final List<Connection> connections;

    public ConnectionsDto(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionsDto that = (ConnectionsDto) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
