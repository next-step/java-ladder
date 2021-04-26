package step02.ladder;

import java.util.Random;

public class DeduplicationLineStrategy implements LineStrategy {
    private final static int ZERO = 0;

    @Override
    public boolean makeLine(int height, int yPoint, boolean isBeforeLineHasLine) {
        if (yPoint == ZERO) {
            return randomCreateLine();
        }
        if(yPoint < height) {
            return isHasLine(isBeforeLineHasLine);
        }
        return false;
    }

    private boolean isHasLine(boolean isBeforeLineHasLine) {
        if (isBeforeLineHasLine) {
            return false;
        }
        return randomCreateLine();
    }

    private boolean randomCreateLine() {
        Random random = new Random();
        return random.nextBoolean();
    }


}
