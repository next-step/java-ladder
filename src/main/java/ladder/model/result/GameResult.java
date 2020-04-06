package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.prize.LadderPrizes;
import ladder.model.prize.PrizeName;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameResult {
    private Map<PlayerName, PrizeName> result;

    public GameResult(Map<PlayerName, PrizeName> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static GameResult create(PositionResult finalLocationByName, LadderPrizes ladderPrizes) {
        Map<PlayerName, PrizeName> gameResult = new HashMap<>();

        finalLocationByName.getKeySet().stream()
                .forEach(it -> gameResult.put(it, ladderPrizes.findPrizeNameAtIndex(finalLocationByName.getPosition(it).getPosition())));

        return new GameResult(gameResult);
    }

    public String findPrizeByPlayerName(String name) {
        return result.get(new PlayerName(name)).getPrizeName();
    }

    public Set<PlayerName> getKeySet() {
        return result.keySet();
    }
}