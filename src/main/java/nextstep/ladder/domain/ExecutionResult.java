package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.lang3.StringUtils;

public class ExecutionResult {

    private String executionResult;

    private ExecutionResult(String executionResult) {
        this.executionResult = executionResult;
    }

    public static ExecutionResult of(String executionResult) {
        return new ExecutionResult(executionResult);
    }

    public String convertExecutionResultWithLeftPad() {
        return StringUtils.leftPad(this.executionResult, LadderConstants.MAXIMUM_EXECUTION_RESULT_LENGTH + 1);
    }

    @Override
    public String toString() {
        return this.executionResult;
    }
}
