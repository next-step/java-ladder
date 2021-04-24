package finalRefactor.domain;

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

    private List<ExecutionResult> createResult(String inputResults) {
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

    public List<ExecutionResult> all() {
        return results;
    }

    public ExecutionResult eachPositionExecutionResult(int position, Ladder ladder) {

        for (LadderLine line : ladder.lines()) {
            position = line.move(position);
        }

        return results.get(position);
    }

    public ExecutionResults getExecutionResult(Ladder ladder) {
        List<ExecutionResult> executionResultsList = new ArrayList<>();
        for (int i = 0; i < ladder.lineSize(); i++) {
            executionResultsList.add(eachPositionExecutionResult(i, ladder));
        }
        return new ExecutionResults(executionResultsList);
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
        return "ExecutionResults{" +
                "results=" + results +
                '}';
    }
}
