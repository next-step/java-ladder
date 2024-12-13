package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> ladderResult;

    private LadderResult(Map<String, String> ladderResult) {
        this.ladderResult = new HashMap<>(ladderResult);
    }

    public static LadderResult of(Map<String, String> ladderResult) {
        return new LadderResult(ladderResult);
    }

    public Map<String, String> getLadderResult() {
        return Collections.unmodifiableMap(ladderResult);
    }
}
