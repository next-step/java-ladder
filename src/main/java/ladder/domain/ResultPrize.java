package ladder.domain;

import java.util.Map;

public class ResultPrize {

    private final Map<String, String> result;

    private ResultPrize(Map<String, String> result) {
        this.result = result;
    }

    public static ResultPrize of(Map<String, String> result) {
        return new ResultPrize(result);
    }

    public Map<String, String> getResult() {
        return result;
    }
}
