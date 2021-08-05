package nextstep.ladder.domain.dto;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LadderPlayerGameResult {
    private final Map<String, PlayerRecord> result;

    private LadderPlayerGameResult(Map<String, PlayerRecord> result) {
        this.result = result;
    }

    public static LadderPlayerGameResult of(Map<String, PlayerRecord> matchResult) {
        return new LadderPlayerGameResult(matchResult);
    }

    public Set<String> getPlayers() {
        return result.keySet();
    }

    public String getRecords(String player) {
        return Optional.ofNullable(result.get(player))
                .orElse(PlayerRecord.empty())
                .getRecord();
    }

}
