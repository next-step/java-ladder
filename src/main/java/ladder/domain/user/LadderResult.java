package ladder.domain.user;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private static final int USER_COUNT_ONE = 1;

    private Map<Username, String> resultMap;

    private LadderResult(Map<Username, String> resultMap) {
        this.resultMap = resultMap;
    }

    public static LadderResult of(Map<Username, String> resultMap) {
        return new LadderResult(resultMap);
    }

    public boolean isOneUser() {
        return resultMap.size() == USER_COUNT_ONE;
    }

    public String getResultOne() {
        return resultMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .findFirst().orElse("");
    }

    public Map<Username, String> findAll() {
        return Collections.unmodifiableMap(resultMap);
    }
}
