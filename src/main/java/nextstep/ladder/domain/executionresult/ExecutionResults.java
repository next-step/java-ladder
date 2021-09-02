package nextstep.ladder.domain.executionresult;

import java.util.List;
import java.util.stream.Stream;

public class ExecutionResults {

    private final List<ExecutionResult> executionResult;

    public ExecutionResults(List<ExecutionResult> executionResult) {
        this.executionResult = executionResult;
    }

    public Stream<ExecutionResult> stream() {
        return executionResult.stream();
    }


}
