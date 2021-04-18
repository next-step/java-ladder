package ladder.controller.dto;

import ladder.service.dto.LadderGameResult;

import java.util.List;

public class LadderGenerationResponse {

    private final List<String> participantNames;
    private final int ladderWidth;
    private final List<LadderLine> ladderLines;
    private final List<String> matchingItems;
    private final List<LadderGameResult> ladderGameResults;

    public LadderGenerationResponse(List<String> participantNames, int ladderWidth, List<LadderLine> ladderLines, List<String> matchingItems, List<LadderGameResult> ladderGameResults) {
        this.participantNames = participantNames;
        this.ladderWidth = ladderWidth;
        this.ladderLines = ladderLines;
        this.matchingItems = matchingItems;
        this.ladderGameResults = ladderGameResults;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public List<String> getMatchingItems() {
        return matchingItems;
    }

    public List<LadderGameResult> getLadderGameResults() {
        return ladderGameResults;
    }
}
