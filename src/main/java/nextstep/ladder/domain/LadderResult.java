package nextstep.ladder.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class LadderResult {
    private Map<String, String> ladderResult;

    public LadderResult(Map<String, String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String get(String player) {
        return ladderResult.get(player);
    }

    public boolean containPlayer(String player) {
        String trimmedPlayer = player.trim();
        return ladderResult.containsKey(trimmedPlayer);
    }

    public Set<String> ketSet() {
        return ladderResult.keySet();
    }
}
