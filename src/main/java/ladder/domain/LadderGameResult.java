package ladder.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<Player, Prize> gameResult;

    public LadderGameResult(Map<Player, Prize> gameResult) {
        this.gameResult = gameResult;
    }

    public Prize findPrizeByPlayerName(String playerName) {
        return gameResult.get(new Player(playerName));
    }

    public Map<Player, Prize> getGameResult() {
        return gameResult;
    }
}
