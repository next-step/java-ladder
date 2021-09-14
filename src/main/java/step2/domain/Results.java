package step2.domain;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
