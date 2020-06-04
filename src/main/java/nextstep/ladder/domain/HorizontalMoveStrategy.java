package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.NotExistMoveStrategyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum HorizontalMoveStrategy {
    MOVE_LEFT(new Direction(true, false)),
    MOVE_RIGHT(new Direction(false, true)),
    STAY(new Direction(false, false));

    private final Direction direction;
    private static final Map<Direction, HorizontalMoveStrategy> cachedHorizontalMoveStrategies = createCache();


    HorizontalMoveStrategy(Direction direction) {
        this.direction = direction;
    }

    public static HorizontalMoveStrategy find(boolean currentPointStatus, boolean nextPointStatus) {
        return Optional.ofNullable(cachedHorizontalMoveStrategies.get(
                new Direction(currentPointStatus, nextPointStatus)))
                .orElseThrow(() -> new NotExistMoveStrategyException("Such HorizontalMoveStrategy not exist"));
    }

    private static Map<Direction, HorizontalMoveStrategy> createCache() {
        Map<Direction ,HorizontalMoveStrategy> cache = new HashMap<>();
        Stream.of(values())
                .forEach(horizontalMoveStrategy ->
                        cache.put(horizontalMoveStrategy.getDirection(), horizontalMoveStrategy));
        return Collections.unmodifiableMap(cache);
    }

    public Direction getDirection() {
        return this.direction;
    }
}
