package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {
    private final Map<String, String> result;

    public LadderResult(Map<String, String> result) {
        this.result = new HashMap<>(result);
    }

    public Map<String, String> getResult() {
        return result;
    }

    public String getResult(String name) {
        return result.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result);
    }
}
