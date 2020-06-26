package nextstep.ladder.domain.result;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<Player, LadderResult> gameResults = new HashMap<>();

    private GameResult(Players players, LadderLines ladderLines, LadderResults ladderResults) {
        for (int i = 0; i < players.getPlayerCount(); i++) {
            gameResults.put(players.find(i), ladderResults.find(ladderLines.findLastPlayerPosition(i)));
        }
    }

    public static GameResult of(Ladder ladder) {
        return new GameResult(ladder.getPlayers(), ladder.getLadderLines(), ladder.getLadderResults());
    }

    public LadderResult getResult(Player player) {
        return gameResults.get(player);
    }

    public Map<Player, LadderResult> getGameResults() {
        return Collections.unmodifiableMap(gameResults);
    }
}
