package nextstep.ladder.domain.result;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Results {
    private final List<String> results;

    private Results(List<String> results) {
        this.results = Collections.unmodifiableList(results);
    }

    public static Results of(List<String> results) {
        return new Results(results);
    }

    public String getResult(int ladderNumber) {
        return results.get(ladderNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }

    public int size() {
        return results.size();
    }

    public List<String> getResults() {
        return results;
    }
}
