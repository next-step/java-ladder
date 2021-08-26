package step2.ladderGame.domain.ladder.pointGenerationStrategy;

import step2.ladderGame.domain.ladder.Point;

import java.util.Random;

public class LadderRandomGenerationStrategy implements LadderGenerationStrategy {

    private static Random random = new Random();

    public boolean createLadder(Point prePoint) {
        if (prePoint.equals(new Point(true))) {
            return false;
        }
        return random.nextBoolean();
    }

}
