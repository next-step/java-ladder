package laddergame.domain;

import java.util.*;

public class LadderLineConnections {

    private static final int MIN_NUMBER_OF_CONNECTIONS = 0;
    private static final Random RANDOM = new Random();

    private final List<Boolean> connections;

    public LadderLineConnections(List<Boolean> connections) {
        validate(connections);
        this.connections = connections;
    }

    private void validate(List<Boolean> connections) {
        boolean previousConnected = false;
        for (boolean currentConnected : connections) {
            validateContinuousConnection(currentConnected, previousConnected);
            previousConnected = currentConnected;
        }
    }

    private void validateContinuousConnection(boolean currentConnected, boolean previousConnected) {
        if (previousConnected && currentConnected) {
            throw new IllegalArgumentException("가로 라인은 연속으로 연결될 수 없습니다.");
        }
    }

    public static LadderLineConnections from(int numberOfConnections) {
        if (numberOfConnections < MIN_NUMBER_OF_CONNECTIONS) {
            throw new IllegalArgumentException(String.format("Connection의 개수는 최소 %d 개 이상이어야 합니다.", MIN_NUMBER_OF_CONNECTIONS));
        }

        if (numberOfConnections == MIN_NUMBER_OF_CONNECTIONS) {
            return new LadderLineConnections(Collections.emptyList());
        }

        List<Boolean> connections = new ArrayList<>();
        connections.add(generateRandomConnection());
        for (int i = 1; i < numberOfConnections; i++) {
            connections.add(generateConnection(connections.get(i - 1)));
        }
        return new LadderLineConnections(connections);
    }

    private static boolean generateConnection(boolean previousConnected) {
        if (previousConnected) {
            return false;
        }
        return generateRandomConnection();
    }

    private static boolean generateRandomConnection() {
        return RANDOM.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLineConnections that = (LadderLineConnections) o;
        return Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }

    @Override
    public String toString() {
        return "LadderLineConnections{" +
                "connections=" + connections +
                '}';
    }

}
