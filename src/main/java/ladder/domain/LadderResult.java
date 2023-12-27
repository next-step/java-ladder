package ladder.domain;

import java.util.Map;

public class LadderResult {

    private Map<String, String> result;

    public LadderResult(Map<String, String> result) {
        this.result = result;
    }

    public String getSelectResult(String selected) {
        if (selected.equals("all")) {
            return this.toString();
        }
        return result.get(selected);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String key : result.keySet()) {
            builder.append(key + " : " + result.get(key) + "\n");
        }
        return builder.toString();
    }
}
