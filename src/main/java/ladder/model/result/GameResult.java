package ladder.model.result;

import ladder.model.player.PlayerName;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrizes;
import ladder.model.prize.PrizeName;
import ladder.model.row.Rows;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameResult {
    private Map<PlayerName, PrizeName> result;

    public GameResult(Map<PlayerName, PrizeName> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static GameResult create(Players players, LadderPrizes ladderPrizes) {
        Map<PlayerName, PrizeName> gameResult = new HashMap<>();

        players.getPlayers().stream()
                .forEach(player -> gameResult.put(player.getName(), ladderPrizes.findPrizeNameByPlayer(player)));

        return new GameResult(gameResult);
    }

    public String findPrizeByPlayerName(String name) {
        return result.get(new PlayerName(name)).getPrizeName();
    }

    public Set<PlayerName> getKeySet() {
        return result.keySet();
    }

//    private void moveAllPlayers(Rows rows, Players players) {
//        players.getPlayers().stream()
//                .forEach(player -> player.findFinalLocation(rows));
//    }
}