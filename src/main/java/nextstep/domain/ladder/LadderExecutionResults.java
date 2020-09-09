package nextstep.domain.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderExecutionResults {

    private final Map<String, LadderExecutionResult> ladderExecutionResult;

    public LadderExecutionResults(List<LadderExecutionResult> ladderExecutionResults) {
        ladderExecutionResult = ladderExecutionResults.stream()
                .collect(Collectors.toMap(LadderExecutionResult::getName, Function.identity()));
    }

    public Map<String, LadderExecutionResult> getLadderExecutionResult() {
        return ladderExecutionResult;
    }

    public LadderExecutionResult getLadderResultByName(String name) {
        return ladderExecutionResult.get(name);
    }

}
