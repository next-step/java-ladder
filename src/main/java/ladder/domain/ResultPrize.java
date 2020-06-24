package ladder.domain;

import java.util.Map;

public class ResultPrize {

    private final Map<String, String> result;

    public ResultPrize(Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> getResult() {
        return result;
    }
}
