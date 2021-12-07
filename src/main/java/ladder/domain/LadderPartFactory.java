package ladder.domain;

import java.util.Random;

public class LadderPartFactory {

    public LadderPart ladderPart(int idx, Rung rung) {
        if (idx % 2 == 0) {
            return Rail.rail();
        }

        if (Rung.rung(false).equals(rung)) {
            return Rung.rung(randomBoolean());
        }

        return Rung.rung(false);
    }

    private static boolean randomBoolean() {
        return new Random().nextBoolean();
    }

}
