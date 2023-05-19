package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class ExecutionResult {

    private final Map<Gamer, Result> results;

    public ExecutionResult(Map<Gamer, Result> results) {
        this.results = results;
    }

    public static ExecutionResult of(Map<Gamer, Result> results) {
        return new ExecutionResult(results);
    }

    public Map<Gamer, Result> getResults() {
        return Collections.unmodifiableMap(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResult result = (ExecutionResult) o;
        return Objects.equals(results, result.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
