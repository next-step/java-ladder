package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private final Connections connections;

    public Line(Boolean...connections) {
        this(Arrays.stream(connections)
                .map(Connection::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public Line(List<Connection> connections) {
        this(new Connections(connections));
    }

    public Line(Connections connections) {
        this.connections = connections;
    }

    public List<Connection> connections() {
        return connections.connections();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(connections, line.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
