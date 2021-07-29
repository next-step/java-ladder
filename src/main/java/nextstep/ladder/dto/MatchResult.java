package nextstep.ladder.dto;

import java.util.Map;
import java.util.Set;

public class MatchResult {
    private final Map<String, String> matchResult;

    private MatchResult(Map<String, String> matchResult) {
        this.matchResult = matchResult;
    }

    public static MatchResult from(Map<String, String> matchResult) {
        return new MatchResult(matchResult);
    }

    public Set<String> getPlayers() {
        return matchResult.keySet();
    }

    public String getPrize(String player) {
        return matchResult.get(player);
    }

    public boolean notParticipate(String player) {
        return !matchResult.containsKey(player);
    }
}
