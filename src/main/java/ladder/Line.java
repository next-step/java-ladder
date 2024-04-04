package ladder;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> connections;

    private Line(final List<Boolean> connections) {
        this.connections = connections;
    }

    public static Line from(final PlayersCount playersCount, final ConnectionGenerator connectionGenerator) {
        return new Line(createConnections(playersCount, connectionGenerator));
    }

    private static List<Boolean> createConnections(
            final PlayersCount playersCount,
            final ConnectionGenerator connectionGenerator
    ) {
        final List<Boolean> connections = new ArrayList<>();
        connections.add(connectionGenerator.generate());

        IntStream.range(1, playersCount.value())
                .mapToObj(i -> connections.get(i - 1) ? FALSE : connectionGenerator.generate())
                .forEach(connections::add);

        return connections;
    }
}
