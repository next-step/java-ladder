package nextstep.laddergame.domain;

import java.util.Map;
import java.util.Set;

public class LadderResult {
    Map<String, String> ladderResults;

    public LadderResult(Map<String, String> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public String outputOf(String participantName) {
        return ladderResults.get(participantName);
    }

    public Set<String> keys() {
        return ladderResults.keySet();
    }
}
