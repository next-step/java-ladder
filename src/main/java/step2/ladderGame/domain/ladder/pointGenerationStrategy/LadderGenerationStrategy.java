package step2.ladderGame.domain.ladder.pointGenerationStrategy;

import step2.ladderGame.domain.ladder.Point;

public interface LadderGenerationStrategy {
    boolean createLadder(Point prePoint);
}
