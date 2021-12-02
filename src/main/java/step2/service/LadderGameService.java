package step2.service;

import step2.domain.GameHistory;
import step2.domain.Ladder;
import step2.domain.LadderInfo;

public class LadderGameService {
    public static final int START_POSITION = 0;

    public GameHistory start(Ladder ladder, LadderInfo ladderInfo) {
        GameHistory gameHistory = GameHistory.of();
        for (int position = START_POSITION; position < ladderInfo.getWidth(); position++) {
            int result = ladder.run(position);
            gameHistory.record(position, result);
        }
        return gameHistory;
    }
}
