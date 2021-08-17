package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Results {
    private final List<String> results;

    private Results(List<String> results){
        this.results = results;
    }

    public static Results of(List<String> results) {
        return new Results(results);
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

    public List<String> getList() {
        return Collections.unmodifiableList(results);
    }
}
