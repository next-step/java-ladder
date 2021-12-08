package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private static final int START_INDEX = 0;

    private final Map<Player, Result> playerResult;

    private LadderResult(Map<Player, Result> playerResult) {
        this.playerResult = playerResult;
    }

    public static LadderResult from(Players players, Ladder ladder, Results results) {
        Map<Player, Result> playerResultMap = new HashMap<>();

        for (int index = START_INDEX; index < players.playersCount(); index++) {
            Player player = players.playerOfIndex(index);
            Result result = results.resultOfIndex(ladder.resultOfIndex(index));

            playerResultMap.put(player, result);
        }

        return new LadderResult(playerResultMap);
    }

    public Result resultOfPlayer(Player player) {
        return playerResult.get(player);
    }

    public Map<Player, Result> resultsOfAllPlayers() {
        return Collections.unmodifiableMap(playerResult);
    }
}
