package step2.domain;

import java.util.Collections;
import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> result;

    public LadderGameResult(Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
