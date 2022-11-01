package ladder;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResultDto {

    private final Map<String, String> results;

    public LadderResultDto() {
        this.results = new LinkedHashMap<>();
    }

    public void addResult(String name, String reward) {
        this.results.put(name, reward);
    }

    public Map<String, String> getResult() {
        return this.results;
    }

}
