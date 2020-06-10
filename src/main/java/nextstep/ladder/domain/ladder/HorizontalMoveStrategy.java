package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.exceptions.NotExistMoveStrategyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum HorizontalMoveStrategy {
    MOVE_LEFT(new Direction(true, false),
            (Player player) -> player.getHorizontalLocation().moveLeft(), -1),
    MOVE_RIGHT(new Direction(false, true),
            (Player player) -> player.getHorizontalLocation().moveRight(), 1),
    STAY(new Direction(false, false),
            Player::getHorizontalLocation, 0);

    private final Direction direction;
    private HorizontalMove horizontalMove;
    private final int moveValue;
    private static final Map<Direction, HorizontalMoveStrategy> cachedHorizontalMoveStrategies = createCache();

    HorizontalMoveStrategy(Direction direction, HorizontalMove horizontalMove, int moveValue) {
        this.direction = direction;
        this.horizontalMove = horizontalMove;
        this.moveValue = moveValue;
    }

    // TODO: 향후 Direction으로 찾는 find만 남기고 삭제할 것
    public static HorizontalMoveStrategy find(boolean currentPointStatus, boolean nextPointStatus) {
        return Optional.ofNullable(cachedHorizontalMoveStrategies.get(
                new Direction(currentPointStatus, nextPointStatus)))
                .orElseThrow(() -> new NotExistMoveStrategyException("Such HorizontalMoveStrategy not exist"));
    }

    public static HorizontalMoveStrategy findByDirection(Direction direction) {
        return Optional.ofNullable(cachedHorizontalMoveStrategies.get(direction))
                .orElseThrow(() -> new NotExistMoveStrategyException("Such HorizontalMoveStrategy not exist"));
    }

    public HorizontalLocation move(Player player) {
        return horizontalMove.move(player);
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

    public int getMoveValue() {
        return moveValue;
    }
}
