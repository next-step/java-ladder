package ladder.domain.ladder.line;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.ladder.Width;

public class Line {

    private final List<Boolean> connections;

    public Line(final List<Boolean> connections) {
        this.connections = connections;
    }

    public int width() {
        return this.connections.size() + 1;
    }

    public List<Boolean> connections() {
        return this.connections.stream()
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
        final int leftConnectionIndex = currentPosition - 1;
        final int rightConnectionIndex = currentPosition;

        if (isConnected(leftConnectionIndex)) {
            return currentPosition - 1;
        }

        if (isConnected(rightConnectionIndex)) {
            return currentPosition + 1;
        }

        return currentPosition;
    }

    private boolean isConnected(final int connectionIndex) {
        if (connectionIndex < 0 || connectionIndex >= this.connections.size()) {
            return false;
        }

        return this.connections.get(connectionIndex);
    }

    public static Line of(final Width width, final ConnectionGenerator connectionGenerator) {
        return new Line(createConnections(width, connectionGenerator));
    }

    private static List<Boolean> createConnections(final Width width, final ConnectionGenerator connectionGenerator) {
        final List<Boolean> connections = new ArrayList<>();
        connections.add(connectionGenerator.generate());

        IntStream.range(1, width.connectionCount())
                .mapToObj(i -> connections.get(i - 1) ? FALSE : connectionGenerator.generate())
                .forEach(connections::add);

        return connections;
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
