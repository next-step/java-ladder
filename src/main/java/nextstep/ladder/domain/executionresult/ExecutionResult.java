package nextstep.ladder.domain.executionresult;

import java.util.List;
import java.util.stream.Stream;

public class ExecutionResult {

    private final List<String> executionResult;

    public ExecutionResult(List<String> executionResult) {
        this.executionResult = executionResult;
    }

    public Stream<String> stream() {
        return executionResult.stream();
    }


}
