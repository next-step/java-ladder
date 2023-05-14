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

    private List<Boolean> createConnections(int numberOfConnections) {
        if(numberOfConnections == ZERO) {
            return Collections.emptyList();
        }

        List<Boolean> connections = new ArrayList<>();
        connections.add(randomBoolean());

        IntStream.range(ONE, numberOfConnections)
                .mapToObj(index -> createConnection(previousElementOf(connections, index)))
                .forEach(connections::add);
        return connections;
    }

    private Boolean createConnection(boolean previousElement) {
        if(previousElement) {
            return false;
        }

        return randomBoolean();
    }

    private Boolean previousElementOf(List<Boolean> connections, int index) {
        return connections.get(index - ONE);
    }

    private Boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
