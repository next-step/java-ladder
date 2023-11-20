package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    Map<String, String> result;

    public LadderResult() {
        this.result = new LinkedHashMap<>();
    }

    public void add(String userName, String userResult) {
        this.result.put(userName, userResult);
    }

    public Map<String, String> result() {
        return this.result;
    }
}
