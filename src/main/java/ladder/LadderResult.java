package ladder;

import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private final Map<String, String> results;

    public LadderResult(Map<String, String> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LadderResult))
            return false;
        LadderResult that = (LadderResult)o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(results);
    }

    public Map<String, String> getResults() {
        return results;
    }

    public String getOne(String keyName) {
        if (!results.containsKey(keyName)) {
            throw new IllegalArgumentException();
        }
        return results.get(keyName);
    }
}
