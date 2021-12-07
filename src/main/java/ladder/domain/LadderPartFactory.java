package ladder.domain;

import java.util.Random;
import java.util.function.Predicate;

public class LadderPartFactory {

    private static final Predicate<Integer> RAIL_CHECK = idx -> idx % 2 == 0;

    public static LadderPart ladderPart(int idx, PreviousRung previousRung) {
        return ladderPart(idx, previousRung.isSet());
    }

    public static LadderPart ladderPart(int idx, boolean isRungSet) {
        if (RAIL_CHECK.test(idx)) {
            return Rail.rail();
        }

        if (!isRungSet) {
            return Rung.rung(randomBoolean());
        }

        return Rung.rung(false);
    }

    private static boolean randomBoolean() {
        return new Random().nextBoolean();
    }

}
