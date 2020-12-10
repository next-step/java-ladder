package ladder.domain;

import java.util.Random;

public class LadderPoint {
    private static Random random = new Random();

    private boolean ladderPoint;

    public LadderPoint(final boolean ladderPoint) {
        this.ladderPoint = initPoint(ladderPoint);
    }

    private boolean initPoint(boolean point) {
        if (point) {
            return false;
        }

        return new Boolean(random.nextBoolean());
    }

    public boolean isLadderPoint() {
        return this.ladderPoint;
    }
}