package ladder.controller.dto;

import java.util.List;

public class LadderGameRequest {

    private final List<String> participantNames;
    private final List<LadderLine> ladderLines;
    private final List<String> gameResults;
    private final String inquiryTargetName;

    public LadderGameRequest(List<String> participantNames, List<LadderLine> ladderLines, List<String> gameResults, String inquiryTargetName) {
        this.participantNames = participantNames;
        this.ladderLines = ladderLines;
        this.gameResults = gameResults;
        this.inquiryTargetName = inquiryTargetName;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public List<String> getGameResults() {
        return gameResults;
    }

    public String getInquiryTargetName() {
        return inquiryTargetName;
    }
}
