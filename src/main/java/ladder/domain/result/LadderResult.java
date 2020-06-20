package ladder.domain.result;

import ladder.utils.StringUtils;

public class LadderResult {

    private final String result;

    private LadderResult(String result) {
        this.result = result;
    }

    public static LadderResult of(String result) {
        StringUtils.validate(result);
        return new LadderResult(result);
    }

    public String getResult() {
        return result;
    }
}
