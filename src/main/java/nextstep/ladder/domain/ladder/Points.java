package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Points {

    private final List<ConnectionStatus> connectionStatuses;

    private Points(List<ConnectionStatus> connectionStatuses) {
        this.connectionStatuses = connectionStatuses;
    }

    public static Points initialize(int size, BooleanGenerator booleanGenerator) {
        Points points = new Points(new ArrayList<>());
        IntStream.range(0, size)
                .forEach(index -> points.addConnect(index, booleanGenerator));
        return points;
    }

    private void addConnect(int index, BooleanGenerator booleanGenerator) {
        if (isNotAddableTrue(index)) {
            connectionStatuses.add(new ConnectionStatus(false));
            return;
        }
        connectionStatuses.add(new ConnectionStatus(booleanGenerator.getBoolean()));
    }

    private boolean isNotAddableTrue(int index) {
        return index != 0 && getConnectionStatus(index - 1).isConnected();
    }

    private ConnectionStatus getConnectionStatus(int index) {
        return connectionStatuses.get(index);
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return connectionStatuses;
    }

    public int size() {
        return connectionStatuses.size();
    }

    public boolean isConnected(int index) {
        return getConnectionStatus(index).isConnected();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return Objects.equals(connectionStatuses, points.connectionStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionStatuses);
    }

    @Override
    public String toString() {
        return "\nLineRows{" +
                "connectionStatuses=" + connectionStatuses +
                '}';
    }
}
