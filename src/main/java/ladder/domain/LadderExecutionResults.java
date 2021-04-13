package ladder.domain;

public class LadderExecutionResults {
    private final Ladder ladder;
    private final ExecutionResults executionResults;

    private LadderExecutionResults(final Ladder ladder, final ExecutionResults executionResults) {
        this.ladder = ladder;
        this.executionResults = executionResults;
    }

    public static LadderExecutionResults of(final Ladder ladder, final ExecutionResults executionResults) {
        return new LadderExecutionResults(ladder, executionResults);
    }

    public String getExecutionResult(int index) {
        return executionResults.getExecutionResult(ladder.getResultIndex(index));
    }
}
