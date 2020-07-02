package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;

public class GameResult {

    private final Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = result;
    }

    public String findResult(String name) {
        return result.get(name);
    }

    public Map<String, String> findAllResult() {
        return Collections.unmodifiableMap(result);
    }
}
