package nextstep.ladder.domain.result;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<Player, LadderResult> gameResults = new HashMap<>();

    private GameResult(Players players, Lines lines, LadderResults ladderResults) {
        for(int i = 0; i < players.getPlayerCount(); i++) {
            gameResults.put(players.find(i), ladderResults.find(findLastPlayerPosition(lines, i)));
        }
    }

    public static GameResult of(Ladder ladder) {
        return new GameResult(ladder.getPlayers(), ladder.getLines(), ladder.getLadderResults());
    }

    private int findLastPlayerPosition(Lines lines, int playerPosition) {
        for(int i = 0; i < lines.getLines().size(); i++) {
            playerPosition = lines.getLines().get(i).findNextPosition(playerPosition);
        }

        return playerPosition;
    }

    public LadderResult getResult(Player player) {
        return gameResults.get(player);
    }

    public Map<Player, LadderResult> getGameResults() {
        return Collections.unmodifiableMap(gameResults);
    }
}
