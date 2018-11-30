package ladderTDD.domain.levels;

import java.util.Random;

public class IntermediateLadderLevel extends LadderLevel {
    private static final int MAX_BOUND = 100;
    private static final Level INTERMEDIATE_LEVEL = Level.INTERMEDIATE;

    @Override
    public int getHeight() {
        return INTERMEDIATE_LEVEL.getLadderHeight();
    }

    @Override
    public Boolean generateRandomValue() {
        if (INTERMEDIATE_LEVEL == Level.valueByRandomvalue(new Random().nextInt(MAX_BOUND))) {
            return true;
        }
        return false;
    }
}
