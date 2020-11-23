package ladder.domain;

import java.util.function.Supplier;

/**
 * FIXME: implements Generator<Direction>
 * 인터페이스 제네릭에다가 enum 을 넣고 싶은데,
 * 문법상 허용되지 않는다. 방법이 없을까?
 */
public class DirectionStrategy {
    private final Supplier<Boolean> supplier;
    private Direction prevDirection = Direction.DOWN;

    public DirectionStrategy(Supplier<Boolean> supplier) {
        this.supplier = supplier;
    }

    Direction get() {
        return get(supplier.get());
    }

    Direction get(boolean isDown) {
        boolean isLeft = prevDirection == Direction.RIGHT;
        Direction direction = isLeft ? Direction.LEFT :
                isDown ? Direction.DOWN : Direction.RIGHT;
        prevDirection = direction;
        return direction;
    }

    void reset() {
        prevDirection = Direction.DOWN;
    }
}
