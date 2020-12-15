package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.DirectionStrategy;

import java.util.function.BooleanSupplier;

public class ForTestStrategy implements DirectionStrategy {

    private final BooleanSupplier booleanSupplier;

    public ForTestStrategy(BooleanSupplier booleanSupplier) {
        this.booleanSupplier = booleanSupplier;
    }

    @Override
    public boolean next() {
        return this.booleanSupplier.getAsBoolean();
    }
}
