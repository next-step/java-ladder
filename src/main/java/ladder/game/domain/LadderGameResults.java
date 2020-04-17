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

    public Map<Player, Prize> getSpecificPlayerResult(String specificPlayer) {
        Map<Player, Prize> results = new HashMap<>();
        Prize defaultPrize = ladderGameResults.getOrDefault(
                Player.of(specificPlayer),
                Prize.of(String.format(NO_WINNER, specificPlayer)));

        results.put(Player.of(specificPlayer), defaultPrize);
        return results;
    }

    public Map<Player, Prize> getAllPlayersResult() {
        return new HashMap<>(ladderGameResults);
    }

}
