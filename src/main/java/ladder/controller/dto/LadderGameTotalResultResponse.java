package ladder.controller.dto;

import java.util.List;

public class LadderGameTotalResultResponse {

    private final List<String> participantNames;
    private final List<String> gameResults;

    public LadderGameTotalResultResponse(List<String> participantNames, List<String> gameResults) {
        this.participantNames = participantNames;
        this.gameResults = gameResults;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public List<String> getGameResults() {
        return gameResults;
    }
}
