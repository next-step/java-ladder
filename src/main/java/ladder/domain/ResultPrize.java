package ladder.domain;

import java.util.Map;

public class ResultPrize {

    private final Map<String, String> result;

    private ResultPrize(Map<String, String> result) {
        this.result = result;
    }

    public static ResultPrize of(LadderResult ladderGameResult) {
        return new ResultPrize(ladderGameResult.findResult());
    }

    public Map<String, String> getResult() {
        return result;
    }
}
