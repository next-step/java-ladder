package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.utils.Preconditions;

import java.util.List;

public class ExecutionResult {
    private final List<String> executionResults;

    private ExecutionResult(List<String> executionResults) {
        Preconditions.checkEmpty(executionResults, "executionResults는 필수값입니다.");

        this.executionResults = executionResults;
    }

    public static ExecutionResult from(List<String> result) {
        return new ExecutionResult(result);
    }

    public String getExecutionResult(Location location) {
        return executionResults.get(location.getCurrentLocation());
    }

    @GetterForUI
    public List<String> getExecutionResults() {
        return executionResults;
    }
}
