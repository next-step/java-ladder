package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> result;

    public LadderGameResult(Map<String, String> result) {
        this.result = new LinkedHashMap<>(result);
    }

    public Map<String, String> getResult() {
        return new LinkedHashMap<>(this.result);
    }
}
