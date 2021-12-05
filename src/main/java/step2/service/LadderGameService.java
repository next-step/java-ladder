package step2.service;

import step2.domain.GameHistory;
import step2.domain.Ladder;
import step2.domain.LadderInfo;
import step2.domain.Position;

public class LadderGameService {
    private static final int START_POSITION = 0;

    public GameHistory start(Ladder ladder, LadderInfo ladderInfo) {
        GameHistory gameHistory = GameHistory.of();
        for (int currentPosition = START_POSITION; currentPosition < ladderInfo.getWidth(); currentPosition++) {
            Position position = Position.of(currentPosition);
            ladder.run(position);
            gameHistory.record(currentPosition, position.position());
        }
        return gameHistory;
    }
}
