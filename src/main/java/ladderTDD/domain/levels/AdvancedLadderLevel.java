package ladderTDD.domain.levels;

import java.util.Random;

/**
 * 상중하 높이 상 -> 20, 중 -> 10, 하 -> 5
 * 상중하 라인 상 -> 57, 중 -> 28, 하 -> 15
 */
public class AdvancedLadderLevel extends LadderLevel {

    private static final int MAX_BOUND = 100;
    private static final Level ADVANCED_LEVEL = Level.ADVANCED;

    @Override
    public int getHeight() {
        return ADVANCED_LEVEL.getLadderHeight();
    }

    @Override
    public Boolean generateRandomValue() {
        if (ADVANCED_LEVEL == Level.valueByRandomvalue(new Random().nextInt(MAX_BOUND))) {
            return true;
        }
        return false;
    }
}
