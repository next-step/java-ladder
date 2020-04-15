package ladder.game.domain;

import ladder.player.domain.Player;
import ladder.prize.domain.Prize;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResults {
    private static final String NO_WINNER = "찾으시는 참여자 %s가 존재하지 않습니다.";
    private final Map<Player, Prize> ladderGameResults;

    private LadderGameResults(Map<Player, Prize> ladderGameResults) {
        this.ladderGameResults = ladderGameResults;
    }

    public static LadderGameResults of(Map<Player, Prize> ladderGameResults) {
        return new LadderGameResults(ladderGameResults);
    }

    public Map<Player, Prize> getLadderGameResults() {
        return ladderGameResults;
    }

    public Map<Player, Prize> getSpecificWinner(String requestWinners) {
        Map<Player, Prize> results = new HashMap<>();
        Player player = Player.of(requestWinners);
        Prize prizeOfSpecificWinner = ladderGameResults.getOrDefault(Player.of(requestWinners),
                Prize.of(String.format(NO_WINNER, requestWinners)));
        results.put(player, prizeOfSpecificWinner);
        return results;
    }
}
