package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    public Map<String, String> play(PlayersGroup playersGroup, Ladder ladder, GamePrizesGroup gamePrizesGroup) {
        Map<String, String> gameResult = new HashMap<>();

        int playerCounts = playersGroup.getPlayerCounts();
        List<String> playerNames = playersGroup.getPlayerNames();
        List<String> gamePrizeNames = gamePrizesGroup.getGamePrizeNames();
        for (int i = 0; i < playerCounts; i++) {
            int resultLocation = ladder.climb(i);
            gameResult.put(playerNames.get(i), gamePrizeNames.get(resultLocation));
        }
        return gameResult;
    }
}
