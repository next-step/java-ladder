package cc.oakk.ladder.model.line;

import cc.oakk.ladder.model.line.dto.ConnectionDto;
import cc.oakk.ladder.model.line.dto.ConnectionsDto;
import cc.oakk.ladder.util.ValidationUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Connections {
    private final List<Connection> connections;

    public Connections(List<Connection> connections) {
        if (connections == null) {
            throw new IllegalArgumentException("주어진 값이 null 입니다.");
        }
        this.connections = Collections.unmodifiableList(connections);
    }

    public Connection get(int index) {
        ValidationUtils.throwIfOutOfListSize(connections, index);
        return connections.get(index);
    }

    public ConnectionsDto getDto() {
        List<ConnectionDto> connectionDtos = connections.stream()
                .map(Connection::getDto)
                .collect(Collectors.toList());
        return new ConnectionsDto(connectionDtos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connections that = (Connections) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
