package step2.domain.direction.strategy;

import step2.domain.direction.Direction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class DiceGenerateStrategy implements DirectionGenerateStrategy {

    private static final int DICE_BOUND = 3;

    private final IntSupplier diceSupplier;

    public DiceGenerateStrategy() {
        this.diceSupplier = () -> new BoundedDice(DICE_BOUND).rollDice();
    }
    //For Test Code
    public DiceGenerateStrategy(IntSupplier diceSupplier) {
        this.diceSupplier = diceSupplier;
    }

    @Override
    public Direction getNextDirection(Direction previous) {
        return getRandomDirectionByFilteringPredicate(validateByNextPoint(previous));
    }

    @Override
    public Direction getDirectionToStart() {
        return getRandomDirectionByFilteringPredicate(predicateNotLeft());
    }

    @Override
    public Direction getDirectionToEnd(Direction previous) {
        return Arrays.stream(Direction.values())
                .filter(predicateNotRight())
                .filter(validateByNextPoint(previous))
                .min(Comparator.comparingInt(Enum::ordinal))
                .get();
    }

    private int rollDice() {
        return diceSupplier.getAsInt();
    }

    private Direction getRandomDirectionByFilteringPredicate(Predicate<Direction> filterCondition) {
        return Arrays.stream(Direction.values())
                .filter(filterCondition)
                .min(Comparator.comparingInt(direction -> rollDice()))
                .get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiceGenerateStrategy that = (DiceGenerateStrategy) o;
        return diceSupplier.equals(that.diceSupplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diceSupplier);
    }
}
