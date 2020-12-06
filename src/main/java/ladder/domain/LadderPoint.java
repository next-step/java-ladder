package ladder.domain;

import java.util.Random;

public class LadderPoint {
    private static Random random = new Random();

    private boolean ladderPoint;

    public LadderPoint(final boolean ladderPoint) {
        initPoint(ladderPoint);
    }

    public void initPoint(boolean point) {
        if (point) {
            this.ladderPoint = false;
            return;
        }

        this.ladderPoint = new Boolean(random.nextBoolean());
    }

    public boolean isLadderPoint() {
        return this.ladderPoint;
    }
}
