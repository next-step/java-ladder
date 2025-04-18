package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Results {
    private final Map<String, String> result;
    private List<Result> results;

    public Results(Map<String, String> result) {
        this.result = new HashMap<>(result);
    }

    public Map<String, String> getResult() {
        return result;
    }

    public String getResult(String name) {
        if (!result.containsKey(name)) {
            throw new IllegalArgumentException("No such result: " + name);
        }
        return result.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Results that = (Results) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(result);
    }
}
