package nextstep.ladder.controller.dto;

import java.util.Map;

public class GameResult {

    private final Map<String, String> result;

    public GameResult(Map<String, String> result) {
        this.result = result;
    }

    public String prize(String name) {
        return result.get(name);
    }
}
