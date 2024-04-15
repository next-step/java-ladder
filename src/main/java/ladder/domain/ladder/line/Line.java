package ladder.domain.ladder.line;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.domain.ladder.Width;

public class Line {

    private final List<Connection> connections;

    public Line(final List<Connection> connections) {
        this.connections = connections;
    }

    public int width() {
        return this.connections.size();
    }

    public List<Connection> connections() {
        return this.connections.stream()
                .map(Connection::copyOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<Integer, Integer> move(final Map<Integer, Integer> route) {
        return route.entrySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(
                        Map.Entry::getKey,
                        entry -> toNextPosition(entry.getValue())
                ));
    }

    private int toNextPosition(final int currentPosition) {
        final Connection currentConnection = this.connections.get(currentPosition);
        final Direction direction = currentConnection.move();

        return currentPosition + direction.delta();
    }

    public static Line of(final Width width, final ConnectionGenerator connectionGenerator) {
        return new Line(createConnections(width, connectionGenerator));
    }

    private static List<Connection> createConnections(
            final Width width,
            final ConnectionGenerator connectionGenerator
    ) {
        final List<Connection> connections = Stream.iterate(
                        connectionGenerator.generateFirst(),
                        connectionGenerator::generateNext
                )
                .limit(width.value() - 1)
                .collect(Collectors.toList());

        final Connection lastConnection = connections.get(connections.size() - 1).last();
        connections.add(lastConnection);

        return Collections.unmodifiableList(connections);
    }

    @Override
    public boolean equals(final Object otherLine) {
        if (this == otherLine) {
            return true;
        }

        if (otherLine == null || getClass() != otherLine.getClass()) {
            return false;
        }

        return Objects.equals(this.connections, ((Line)otherLine).connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.connections);
    }
}
