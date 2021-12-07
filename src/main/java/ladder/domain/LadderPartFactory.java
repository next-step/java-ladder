package ladder.domain;

import java.util.Random;

public class LadderPartFactory {

    public static LadderPart ladderPart(int idx, boolean isRungSet) {
        if (idx % 2 == 0) {
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
