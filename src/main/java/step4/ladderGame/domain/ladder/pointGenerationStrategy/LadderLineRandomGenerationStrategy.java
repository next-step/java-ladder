package step4.ladderGame.domain.ladder.pointGenerationStrategy;

import step4.ladderGame.domain.ladder.Point;

import java.util.Random;

public class LadderLineRandomGenerationStrategy implements LadderLineGenerationStrategy {

    private static Random random = new Random();

    public boolean createLadderLine(final Point prePoint) {
        boolean leftDirection = prePoint.hasRightDirectionLine();

        if (!leftDirection) {
            return random.nextBoolean();
        }

        return false;
    }

}
