package ladder;

import java.util.Random;

public class LadderPartFactory {

    public LadderPart ladderPart(int idx, Rung rung) {
        if (idx % 2 == 0) {
            return Rail.rail();
        }

        if (rung.equals(Rung.rung(false))) {
            return Rung.rung(randomBoolean());
        }

        return Rung.rung(false);
    }

    private static boolean randomBoolean() {
        return new Random().nextBoolean();
    }

}
