package ladder.domain;

import java.util.Map;
import java.util.Objects;

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

    public String getResult(int index) {
        return result.get(index);
    }

    public int size() {
        return result.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
