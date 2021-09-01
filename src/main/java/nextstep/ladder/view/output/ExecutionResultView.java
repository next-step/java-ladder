package nextstep.ladder.view.output;

import nextstep.ladder.domain.executionresult.ExecutionResult;
import nextstep.ladder.view.OutPutViewUtils;

import java.util.stream.Collectors;

public class ExecutionResultView {

    public void appendExecutionResult(ExecutionResult result, StringBuilder stringBuilder) {
        String paddingAddedExecutionResult = result.stream()
                .map(OutPutViewUtils::appendPaddingAfterValue)
                .collect(Collectors.joining(""));

        stringBuilder.append(paddingAddedExecutionResult);
    }
}
