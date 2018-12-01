package ladderTDD.domain.levels;

import java.util.Random;

public class BasicLadderLevel extends LadderLevel {
    private static final int MAX_BOUND = 100;
    private static final Level BASIC_LEVEL = Level.BASIC;

    @Override
    public int getHeight() {
        return BASIC_LEVEL.getLadderHeight();
    }

    @Override
    public Boolean generateRandomValue() {
        if (BASIC_LEVEL == Level.valueByRandomvalue(new Random().nextInt(MAX_BOUND))) {
            return true;
        }
        return false;
    }
}
