package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private Players players;
    private Lines lines;
    private ExecutionResults executionResults;

    private Ladder(List<String> userNames, List<String> executionResults, int ladderHeight) {
        this.players = Players.of(userNames);
        this.executionResults = ExecutionResults.of(executionResults);
        this.lines = Lines.of(userNames.size(), ladderHeight);
    }

    public static Ladder of(List<String> userNames, List<String> executionResult, Integer ladderHeight) {
        return new Ladder(userNames, executionResult, ladderHeight);
    }

    public Players getPlayers() {
        return this.players;
    }

    public Lines getLines() {
        return this.lines;
    }

    public ExecutionResults getExecutionResults() {
        return executionResults;
    }
}
