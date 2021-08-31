package nextstep.laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLineConnectStrategy implements LineConnectStrategy {

    private static final String INVALID_PLAYER_SIZE_EXCEPTION_MESSAGE = "참여자는 한 명 이상이어야 합니다.";
    private static final int COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS = 1;

    private final Random random;
    private final int countOfPoint;

    public RandomLineConnectStrategy(Random random, int countOfPlayer) {
        validatePlayerCount(countOfPlayer);
        this.random = Objects.requireNonNull(random);
        this.countOfPoint = countOfPlayer - COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS;
    }

    private void validatePlayerCount(int countOfPlayer) {
        if (countOfPlayer < Players.MINIMUM_COUNT_OF_PLAYER) {
            throw new IllegalArgumentException(INVALID_PLAYER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public static LineConnectStrategy of(Random random, int countOfPlayer) {
        return new RandomLineConnectStrategy(random, countOfPlayer);
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
