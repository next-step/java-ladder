package step3.domain;

import java.util.*;

public class Results {
    private final List<Result> results;

    public Results() {
        results = new ArrayList<>();
    }

    public Results(List<Result> results) {
        this.results = results;
    }

    public Result oneResult(int position) {
        return results.get(position);
    }

    public Results allResult(Results results) {
        return results;
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
        return  results + "";
    }
}
