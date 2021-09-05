package nextstep.laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLineConnectStrategy implements LineConnectStrategy {

    private static final int MINIMUM_COUNT_OF_POINT = 1;
    private static final int COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS = 1;

    private final Random random;
    private final int countOfPoint;

    public RandomLineConnectStrategy(Random random, int countOfPlayer) {
        int countOfPoint = countOfPlayer - COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS;
        validateMinimumPointCount(countOfPoint);
        this.random = Objects.requireNonNull(random);
        this.countOfPoint = countOfPoint;
    }

    private void validateMinimumPointCount(int countOfPoint) {
        if (countOfPoint < MINIMUM_COUNT_OF_POINT) {
            throw new IllegalArgumentException(String.format("사다리 라인의 포인트 수가 유효하지 않습니다. countOfPoint: %s", countOfPoint));
        }
    }

    @Override
    public List<Point> getLineConnections() {
        return Stream.iterate(random.nextBoolean(), this::nextConnection)
                .limit(countOfPoint)
                .map(Point::new)
                .collect(Collectors.toList());
    }

    private boolean nextConnection(Boolean previousPointConnected) {
        return !previousPointConnected && random.nextBoolean();
    }
}
