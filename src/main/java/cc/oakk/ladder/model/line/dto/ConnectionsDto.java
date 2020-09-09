package cc.oakk.ladder.model.line.dto;

import java.util.List;
import java.util.Objects;

public class ConnectionsDto {
    private final List<ConnectionDto> connections;

    public ConnectionsDto(List<ConnectionDto> connections) {
        this.connections = connections;
    }

    public List<ConnectionDto> getConnections() {
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
