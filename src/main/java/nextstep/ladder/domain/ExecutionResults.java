package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExecutionResults {

    private final List<ExecutionResult> executionResults;
    public ExecutionResults(String str) {
        this(str.split(","));
    }

    public ExecutionResults(String[] executionResults) {
        this(Arrays.stream(executionResults)
                .map(ExecutionResult::new)
                .collect(Collectors.toList()));
    }

    public ExecutionResults(List<ExecutionResult> executionResults) {
        if(executionResults == null || executionResults.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.executionResults = executionResults;
    }

    public void validateSize(Participants participants){
        if(this.executionResults.size() != participants.getSize()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExecutionResults)) return false;
        ExecutionResults that = (ExecutionResults) o;
        return Objects.equals(executionResults, that.executionResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionResults);
    }

    public ExecutionResult getByOrder(int i) {
        return this.executionResults.get(i);
    }

    public List<ExecutionResult> getExecutionResults() {
        return executionResults;
    }
}
