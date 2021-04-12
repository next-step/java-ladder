package ladder.domain;

import ladder.util.CollectionsUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ExecutionResults {
    private final List<String> executionResults;

    private ExecutionResults(List<String> executionResults) {
        this.executionResults = executionResults;
    }

    public static ExecutionResults from(String[] executionResults, int countOfPerson) {
        return Arrays.stream(executionResults)
                .collect(collectingAndThen(
                        toList(),
                        executionResultList -> new ExecutionResults(
                                CollectionsUtils.checkSize(executionResultList, countOfPerson))));
    }

    public String getExecutionResult(int index) {
        return executionResults.get(index);
    }

    public List<String> getExecutionResults() {
        return Collections.unmodifiableList(executionResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResults that = (ExecutionResults) o;
        return Objects.equals(executionResults, that.executionResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionResults);
    }
}
