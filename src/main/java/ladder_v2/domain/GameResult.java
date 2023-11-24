package ladder_v2.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private Map<String, String> result = new HashMap<>();

    public GameResult(Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> result(){
        return result;
    }
}
