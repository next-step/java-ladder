package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomConnectionsFactory implements ConnectionsFactory {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    @Override
    public Connections create(int numberOfConnections) {
        return new Connections(createConnections(numberOfConnections));
    }

    private List<Connection> createConnections(int numberOfConnections) {
        if(numberOfConnections == ZERO) {
            return Collections.emptyList();
        }

        List<Connection> connections = new ArrayList<>();
        connections.add(randomConnection());

        IntStream.range(ONE, numberOfConnections)
                .mapToObj(index -> createConnection(previousConnection(connections, index)))
                .forEach(connections::add);
        return connections;
    }

    private Connection createConnection(Connection previousConnection) {
        if(previousConnection.isConnected()) {
            return new Connection(false);
        }

        return randomConnection();
    }

    private Connection previousConnection(List<Connection> connections, int index) {
        return connections.get(index - ONE);
    }

    private Connection randomConnection() {
        return new Connection(ThreadLocalRandom.current().nextBoolean());
    }
}
