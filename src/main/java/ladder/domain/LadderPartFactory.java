package ladder.domain;

import ladder.strategy.MakeRungStrategy;
import ladder.util.function.Function;

import java.util.Random;

public class LadderPartFactory {

    private static final Random RANDOM = new Random();
    private static boolean isPreviousRungSet = false;

    private LadderPartFactory() {}

    public static LadderPart ladderPart(int idx) {
        if (Function.EVEN_NUMBER.test(idx)) {
            return Rail.instance();
        }
        changeIsPreviousRungSet(MakeRungStrategy.of(isPreviousRungSet, RANDOM.nextBoolean()).test());
        return Rung.from(isPreviousRungSet);
    }

    public static void initIsPreviousRungSet() {
        changeIsPreviousRungSet(false);
    }

    public static void changeIsPreviousRungSet(boolean value) {
        isPreviousRungSet = value;
    }

}
