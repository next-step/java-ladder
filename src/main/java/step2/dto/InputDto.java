package step2.dto;

import step2.domain.ExecutionResults;

public class InputDto {
    private final Players players;
    private final ExecutionResults executionResults;

    public InputDto(Players players, ExecutionResults executionResults) {
        this.players = players;
        this.executionResults = executionResults;
    }

    public Players getPlayers() {
        return players;
    }

    public ExecutionResults getExecutionResults() {
        return executionResults;
    }
}
