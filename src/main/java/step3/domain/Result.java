package step3.domain;

import java.util.*;

public class Result {
    private final Lines lines;
    private ExecutionResults executionResults;

    public Result(Lines lines, ExecutionResults executionResults) {
        this.lines = lines;
        this.executionResults = executionResults;
    }

    public List<Integer> getMoveResult() {
        List<Integer> positionList = new ArrayList<>();
        for (int i = 0; i < lines.lines().size(); i++) {
            positionList.add(lines.eachPositionResult(i));
        }
        return positionList;
    }

    public ExecutionResults getExecutionResult() {
        List<ExecutionResult> executionResultsList = new ArrayList<>();
        for (int i = 0; i < executionResults.size(); i++) {
            executionResultsList.add(lines.eachPositionExecutionResult(i, executionResults));
        }
        return new ExecutionResults(executionResultsList);
    }

}
