package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LadderGameResult {
    private final Map<String, String> result;

    public LadderGameResult(Map<String, String> result) {
        this.result = new LinkedHashMap<>(result);
    }

    public Set<String> getPlayerNames(){
        return this.result.keySet();
    }

    public String getPlayerResult(String name) {
        return this.result.getOrDefault(name, null);
    }
}
