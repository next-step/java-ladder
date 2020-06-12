package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private static final int LOOP_ZERO = 0;

    public Map<Player, GamePrize> play(PlayersGroup playersGroup, Ladder ladder, GamePrizesGroup gamePrizesGroup) {
        Map<Player, GamePrize> gameResult = new HashMap<>();
        int playerCounts = playersGroup.getPlayerCounts();
        for (int i = LOOP_ZERO; i < playerCounts; i++) {
            int destinationIndex = ladder.climb(i);
            gameResult.put(playersGroup.valueOf(i), gamePrizesGroup.valueOf(destinationIndex));
        }
        return gameResult;
    }
}
