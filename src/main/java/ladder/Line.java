package ladder;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    static final int MINIMUM_PLAYERS_COUNT = 2;

    private final List<Boolean> connections;

    private Line(final List<Boolean> connections) {
        this.connections = connections;
    }

    public static Line from(final int playersCount, final ConnectionGenerator connectionGenerator) {
        validatePlayersCountIsNotLessThanMinimum(playersCount);

        return new Line(createConnections(playersCount, connectionGenerator));
    }

    private static List<Boolean> createConnections(
            final int playersCount,
            final ConnectionGenerator connectionGenerator
    ) {
        final List<Boolean> connections = new ArrayList<>();
        connections.add(connectionGenerator.generate());

        IntStream.range(1, playersCount)
                .mapToObj(i -> connections.get(i - 1) ? FALSE : connectionGenerator.generate())
                .forEach(connections::add);

        return connections;
    }

    private static void validatePlayersCountIsNotLessThanMinimum(final int playersCount) {
        if (playersCount < MINIMUM_PLAYERS_COUNT) {
            throw new IllegalArgumentException("플레이어 수는 최소 인원 이상이어야 합니다. 플레이어 수: " + playersCount);
        }
    }
}
