package ladder.domain.dto;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;

import java.util.List;

public class LadderInfoDto {

    private final LadderPlayers ladderPlayers;
    private final ExecutionResults executionResults;
    private final LadderHeight height;

    public LadderInfoDto(List<String> printInputNames, List<String> printInputItems, int height) {
        this.ladderPlayers = new LadderPlayers(printInputNames);
        this.executionResults = new ExecutionResults(printInputItems);
        this.height = new LadderHeight(height);
    }

    public LadderPlayers getLadderPlayers() {
        return ladderPlayers;
    }

    public ExecutionResults getExecutionResults() {
        return executionResults;
    }

    public LadderHeight getHeight() {
        return height;
    }

}
