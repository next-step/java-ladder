package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BridgeLine {

    private final List<Boolean> connections;

    public BridgeLine(final List<Boolean> connections) {
        this.connections = connections;
    }

    public int getHeight() {
        return this.connections.size();
    }

    public boolean isConnected(final int height) {
        return this.connections.get(height);
    }

    public boolean hasSameHeightConnection(final BridgeLine bridgeLine) {
        return IntStream.range(0, this.connections.size())
                        .filter(height -> this.connections.get(height) && bridgeLine.connections.get(height))
                        .findFirst()
                        .isPresent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BridgeLine that = (BridgeLine) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
