package step02.ladder;

import java.util.Random;

public class DeduplicationLineStrategy implements LineStrategy {

    @Override
    public boolean makeLine(boolean isBeforeLineHasLine) {
        return isHasLine(isBeforeLineHasLine);
    }

    public boolean makeFirstLine() {
        return randomCreateLine();
    }

    public boolean makeLastLine() {
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
