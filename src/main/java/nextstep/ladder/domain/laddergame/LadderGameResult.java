package nextstep.ladder.domain.laddergame;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> ladderGameResult;

    public LadderGameResult() {
        this(new HashMap<>());
    }

    public LadderGameResult(Map<String, String> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public void add(String name, String result) {
        ladderGameResult.put(name, result);
    }

    public String getResult(String name) {
        return ladderGameResult.get(name);
    }

    public StringBuilder getResultAll() {
        StringBuilder result = new StringBuilder();

        ladderGameResult.forEach((key, value) -> {
            result.append(key)
                  .append(" : ")
                  .append(value)
                  .append("\n");
        });

        return result;
    }

}
