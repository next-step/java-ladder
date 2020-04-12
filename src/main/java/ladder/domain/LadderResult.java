package ladder.domain;

import java.util.Map;

public class LadderResult {
    public static final String INPUT_LADDER_RESULT = "사다리 결과값을 입력해주세요.";
    private Map<Integer, String> result;

    public LadderResult(final Map<Integer, String> result) {
        validateResult(result);
        this.result = result;
    }

    private void validateResult(Map<Integer, String> result) {
        if (result.isEmpty()) {
            throw new IllegalArgumentException(INPUT_LADDER_RESULT);
        }
    }


}
