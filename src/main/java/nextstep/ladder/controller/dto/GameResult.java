package nextstep.ladder.controller.dto;

import java.util.Map;
import java.util.Set;

public class GameResult {

    private final Map<String, String> prizesByName;

    public GameResult(Map<String, String> prizesByName) {
        this.prizesByName = prizesByName;
    }

    public String prize(String name) {
        return prizesByName.get(name);
    }

    public Set<String> names() {
        return prizesByName.keySet();
    }
}
