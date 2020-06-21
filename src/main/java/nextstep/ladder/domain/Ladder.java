package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;

import java.util.List;

public class Ladder {

    private Players players;
    private Lines lines;
    private ExecutionResults executionResults;

    private Ladder(List<String> userNames, List<String> executionResults, int ladderHeight) {

        this.players = Players.of(userNames);
        this.executionResults = ExecutionResults.of(executionResults);

        validateUserNamesAndExecutionResults(userNames, executionResults);

        this.lines = Lines.of(userNames.size(), ladderHeight);
    }

    public static Ladder of(List<String> userNames, List<String> executionResults, Integer ladderHeight) {
        return new Ladder(userNames, executionResults, ladderHeight);
    }

    private static void validateUserNamesAndExecutionResults(List<String> userName, List<String> executionResults) {
        if (userName.size() != executionResults.size()) {
            throw new IllegalArgumentException(LadderConstants.INVALID_USER_NAMES_AND_EXECUTION_RESULTS);
        }
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
