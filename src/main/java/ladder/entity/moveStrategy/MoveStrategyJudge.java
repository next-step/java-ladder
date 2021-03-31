package ladder.entity.moveStrategy;

import ladder.entity.ladderMap.Link;

import java.util.Random;

public class MoveStrategyJudge {

    public static final int CASE_COUNT = 2;
    public static final int ACTIVATION_NUMBER = 1;
    public static final Random random = new Random();

    public static MoveStrategy strategy(Link preLink) {
        if (preLink==null || !preLink.goesRight()){
            return stillOrRight();
        }
        return new MoveLeft();
    }

    private static MoveStrategy stillOrRight() {
        int caseValue = random.nextInt(CASE_COUNT);
        if (caseValue == ACTIVATION_NUMBER) {
            return new MoveRight();
        }
        return new MoveStill();
    }
}
