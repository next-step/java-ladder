package cc.oakk.ladder.model.line.dto;

import cc.oakk.ladder.model.line.Connection;
import cc.oakk.ladder.model.size.LadderWidth;

import java.util.List;
import java.util.Objects;

public class LineDto {
    private final LadderWidth width;
    private final List<Connection> connections;

    public LineDto(LadderWidth width, List<Connection> connections) {
        this.width = width;
        this.connections = connections;
    }

    public LadderWidth getWidth() {
        return width;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineDto lineDto = (LineDto) o;
        return Objects.equals(width, lineDto.width) &&
                Objects.equals(connections, lineDto.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, connections);
    }
}
