package nextstep.laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLineConnectStrategy implements LineConnectStrategy {

    private static final int COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS = 1;

    private final Random random;
    private final int countOfPoint;

    private RandomLineConnectStrategy(Random random, PlayerCount playerCount) {
        this.random = Objects.requireNonNull(random);
        this.countOfPoint = playerCount.getCount() - COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS;
    }

    public static LineConnectStrategy of(Random random, PlayerCount playerCount) {
        return new RandomLineConnectStrategy(random, playerCount);
    }

    @Override
    public List<Boolean> getLineConnections() {
        return Stream.iterate(random.nextBoolean(), this::nextConnection)
                .limit(countOfPoint)
                .collect(Collectors.toList());
    }

    private boolean nextConnection(Boolean previousPointConnected) {
        return !previousPointConnected && random.nextBoolean();
    }
}
