package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<Integer, Integer> ladderResult;

    private LadderResult(Map<Integer, Integer> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult of(Map<Integer, Integer> ladderResult) {
        return new LadderResult(ladderResult);
    }

    public GameResult mappingResult(Players players, Rewards rewards) {
        Map<String, String> result = new HashMap<>();

        for (int index = 0; index < ladderResult.size(); index++) {
            result.put(players.getPlayer(index).getName(), rewards.getReward(ladderResult.get(index)));
        }
        return GameResult.of(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
