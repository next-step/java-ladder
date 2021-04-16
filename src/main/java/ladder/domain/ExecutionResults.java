package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static ladder.util.CollectionsUtils.checkSize;

public class ExecutionResults {
    private final List<String> executionResults;

    private ExecutionResults(final List<String> executionResults) {
        this.executionResults = executionResults;
    }

    public static ExecutionResults from(final String[] executionResults, final int countOfPerson) {
        return Arrays.stream(checkSize(executionResults, countOfPerson))
                .collect(collectingAndThen(
                        toList(),
                        ExecutionResults::new
                ));
    }

    public String getExecutionResult(final int index) {
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
