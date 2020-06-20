package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResult;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public MatchResult findAllPosition(Players players, LadderResults ladderResults) {
        Map<Player, LadderResult> result = new HashMap<>();
        for (int i = 0; i < players.getCountOfPerson(); i++) {
            result.put(players.get(i), ladderResults.get(findResultPosition(i)));
        }
        return new MatchResult(result);
    }

    public int findResultPosition(int playerPosition) {
        for (int lineNumber = 0; lineNumber < ladder.height(); lineNumber++) {
            playerPosition = ladder.get(lineNumber).getNextPosition(playerPosition);
        }
        return playerPosition;
    }
}
