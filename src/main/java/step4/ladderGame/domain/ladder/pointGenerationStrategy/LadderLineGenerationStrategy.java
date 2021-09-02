package step4.ladderGame.domain.ladder.pointGenerationStrategy;


import step4.ladderGame.domain.ladder.Point;

public interface LadderLineGenerationStrategy {
    boolean createLadderLine(Point prePoint);
}
