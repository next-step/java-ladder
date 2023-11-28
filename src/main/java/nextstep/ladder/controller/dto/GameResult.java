package nextstep.ladder.controller.dto;

import java.util.Map;
import java.util.Set;

public class GameResult {

    private final Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = result;
    }

    public String prize(String name) {
        return result.get(name);
    }

    public Set<String> names() {
        return result.keySet();
    }
}
