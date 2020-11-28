package ladder.domain.direction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class DirectionStrategy {

    private static final int DIRECTION_WAY = 3;

    private final IntSupplier directionWaySupplier;

    public DirectionStrategy() {
        this.directionWaySupplier = () -> new Random().nextInt(DIRECTION_WAY);
    }

    //for Test
    public DirectionStrategy(IntSupplier directionWaySupplier) {
        this.directionWaySupplier = directionWaySupplier;
    }

    public Direction getNextDirection(Direction previous) {
        return directionWayByFilteringPredicate(validateByNextPoint(previous));
    }

    public Direction getDirectionToStart() {
        return directionWayByFilteringPredicate(predicateNotLeft());
    }

    public Direction getDirectionToEnd(Direction previous) {
        return Arrays.stream(Direction.values())
            .filter(predicateNotRight())
            .filter(validateByNextPoint(previous))
            .min(Comparator.comparingInt(Enum::ordinal))
            .get();
    }

    private int defineDirectionWay() {
        return directionWaySupplier.getAsInt();
    }

    private Direction directionWayByFilteringPredicate(Predicate<Direction> filterCondition) {
        return Arrays.stream(Direction.values())
            .filter(filterCondition)
            .min(Comparator.comparingInt(direction -> defineDirectionWay()))
            .get();
    }

    private Predicate<Direction> predicateNotLeft() {
        return direction -> direction != Direction.LEFT;
    }

    private Predicate<Direction> predicateNotRight() {
        return direction -> direction != Direction.RIGHT;
    }

    private Predicate<Direction> validateByNextPoint(Direction now) {
        if(now == Direction.RIGHT) {
            return direction -> direction == Direction.LEFT;
        }
        return direction -> direction != Direction.LEFT;
    }
}
