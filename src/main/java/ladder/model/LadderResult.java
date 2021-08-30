package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private static final Map<String, LadderResult> LADDER_RESULTS = new HashMap<>();

    private final String result;

    private LadderResult(String result) {
        validateNotEmpty(result);
        this.result = result;
    }

    static LadderResult of(String result) {
        LadderResult ladderResult = LADDER_RESULTS.get(result);
        if (ladderResult != null) {
            return ladderResult;
        }

        ladderResult = new LadderResult(result);
        LADDER_RESULTS.put(result, ladderResult);
        return ladderResult;
    }

    private void validateNotEmpty(String result) {
        if (result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("사다리 실행 결과가 비었습니다.");
        }
    }

    String getResult() {
        return result;
    }
}
