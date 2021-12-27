package ladderstep4.ladder.domain;

import ladderstep4.ladder.enums.LadderPart;
import ladderstep4.ladder.strategy.MakeRungStrategy;
import ladderstep4.ladder.strategy.RandomRungSupplier;
import ladderstep4.ladder.util.function.MathFunction;

public class LadderPartFactory {

    public static final String STRATEGY_NULL_MESSAGE = "strategy는 null일 수 없습니다.";

    private static MakeRungStrategy strategy = new RandomRungSupplier();
    private static boolean isPreviousRungSet = false;

    private LadderPartFactory() {}

    public static LadderPart ladderPart(int idx) {
        if (MathFunction.EVEN_NUMBER.test(idx)) {
            return LadderPart.RAIL;
        }

        if (isPreviousRungSet) {
            changeIsPreviousRungSet(false);
            return LadderPart.from(isPreviousRungSet);
        }

        changeIsPreviousRungSet(strategy.test());
        return LadderPart.from(isPreviousRungSet);
    }

    public static void setStrategy(MakeRungStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException(STRATEGY_NULL_MESSAGE);
        }
        LadderPartFactory.strategy = strategy;
    }

    public static void initIsPreviousRungSet() {
        changeIsPreviousRungSet(false);
    }

    public static void changeIsPreviousRungSet(boolean value) {
        isPreviousRungSet = value;
    }

}
