package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.NotExistMoveStrategyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum HorizontalMoveStrategy {
    MOVE_LEFT(new Direction(true, false),
            HorizontalLocation::moveLeft, -1),
    MOVE_RIGHT(new Direction(false, true),
            HorizontalLocation::moveRight, 1),
    STAY(new Direction(false, false),
            (HorizontalLocation horizontalLocation) -> horizontalLocation, 0);

    private final Direction direction;
    private HorizontalMove horizontalMove;
    private final int moveValue;
    private static final Map<Direction, HorizontalMoveStrategy> cachedHorizontalMoveStrategies = createCache();

    HorizontalMoveStrategy(Direction direction, HorizontalMove horizontalMove, int moveValue) {
        this.direction = direction;
        this.horizontalMove = horizontalMove;
        this.moveValue = moveValue;
    }

    public static HorizontalMoveStrategy findByDirection(Direction direction) {
        return Optional.ofNullable(cachedHorizontalMoveStrategies.get(direction))
                .orElseThrow(() -> new NotExistMoveStrategyException("Such HorizontalMoveStrategy not exist"));
    }

    public HorizontalLocation move(HorizontalLocation horizontalLocation) {
        return horizontalMove.move(horizontalLocation);
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
