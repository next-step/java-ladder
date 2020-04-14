package ladder.game.domain;

import ladder.player.domain.Player;
import ladder.prize.domain.Prize;

import java.util.Map;

public class LadderGameResults {
    private final List<Player>

    private LadderGameResults(Map<Player, Prize> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }

    public static LadderGameResults of(Map<Player, Prize> ladderGameResults) {
        return new LadderGameResults(ladderGameResults);
    }

    public Map<Player, Prize> getLadderGameResults() {
        return ladderGameResults;
    }

    public Prize getPrizeOfRequestWinner(String requestWinners) {
        return ladderGameResults.get(Player.of(requestWinners));
    }
}
