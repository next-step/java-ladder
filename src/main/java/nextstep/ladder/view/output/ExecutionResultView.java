package nextstep.ladder.view.output;

import nextstep.ladder.domain.executionresult.ExecutionResult;
import nextstep.ladder.domain.executionresult.ExecutionResults;
import nextstep.ladder.view.OutPutViewUtils;

import java.util.stream.Collectors;

public class ExecutionResultView {

    public void appendExecutionResult(ExecutionResults result, StringBuilder stringBuilder) {
        String paddingAddedExecutionResult = result.stream()
                .map(ExecutionResult::toString)
                .map(OutPutViewUtils::appendPaddingAfterValue)
                .collect(Collectors.joining(""));

        stringBuilder.append(paddingAddedExecutionResult);
    }
}
