package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private static final int LOOP_ZERO = 0;

    public GameResult play(PlayersGroup playersGroup, Ladder ladder, GamePrizesGroup gamePrizesGroup) {
        Map<String, String> gameResult = new HashMap<>();
        int playerCounts = playersGroup.getPlayerCounts();
        for (int i = LOOP_ZERO; i < playerCounts; i++) {
            String currentPlayerName = playersGroup.getPlayerNameByIndex(i);
            int destinationIndex = ladder.climb(i);
            String gamePrizeName = gamePrizesGroup.getGamePrizeNameByIndex(destinationIndex);
            gameResult.put(currentPlayerName, gamePrizeName);
        }
        return new GameResult(gameResult);
    }
}
