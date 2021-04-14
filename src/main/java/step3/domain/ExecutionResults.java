package step3.domain;

import java.util.*;
import java.util.stream.Collectors;

public class ExecutionResults {
    private static final String COMMA = ",";
    private final List<ExecutionResult> results;

    public ExecutionResults() {
        results = new ArrayList<>();
    }

    public ExecutionResults(String inputPersons) {
        this.results = createResult(inputPersons);
    }

    public List<ExecutionResult> createResult(String inputResults) {
        String[] results = inputResults.trim().split(COMMA);
        return Arrays.asList(results)
                .stream()
                .map(ExecutionResult::new)
                .collect(Collectors.toList());
    }

    public ExecutionResults(List<ExecutionResult> results) {
        this.results = results;
    }

    public ExecutionResult getOneResult(int position) {
        return results.get(position);
    }

    public int size() {
        return results.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResults results1 = (ExecutionResults) o;
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

    public List<ExecutionResult> all() {
        return results;
    }
}
