package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.DirectionStrategy;

import java.util.function.BooleanSupplier;

public class ForTestStrategy implements DirectionStrategy {

    private final BooleanSupplier booleanSupplier;

    public ForTestStrategy(BooleanSupplier booleanSupplier) {
        this.booleanSupplier = booleanSupplier;
    }

    @Override
    public Direction next() {
        return Direction.of(false, booleanSupplier.getAsBoolean());
    }
}
