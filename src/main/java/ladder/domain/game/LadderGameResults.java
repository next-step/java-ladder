package ladder.domain.game;

import ladder.domain.player.LadderPlayer;

import java.util.Collections;
import java.util.Map;

public class LadderGameResults {
    private final Map<LadderPlayer, LadderReward> results;

    public LadderGameResults(Map<LadderPlayer, LadderReward> results) {
        validateResults(results);
        this.results = Collections.unmodifiableMap(results);
    }

    public LadderReward getLadderReward(LadderPlayer ladderPlayer) {
        validateLadderPlayer(ladderPlayer);
        return results.get(ladderPlayer);
    }

    public Map<LadderPlayer, LadderReward> getResults() {
        return Collections.unmodifiableMap(results);
    }

    private void validateLadderPlayer(LadderPlayer ladderPlayer) {
        if (!results.containsKey(ladderPlayer)) {
            throw new IllegalArgumentException("유효하지 않은 플레이어를 입력했습니다.");
        }
    }


    private void validateResults(Map<LadderPlayer, LadderReward> results) {
        if (results == null) {
            throw new IllegalArgumentException("게임 결과가 올바르지 않습니다.");
        }
    }
}
