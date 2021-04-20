package ladder.controller.dto;

import java.util.List;

public class LadderGenerationResult {

    private final List<String> participants;
    private final List<LadderLine> ladderLines;
    private final int ladderWidth;
    private final List<String> matchingItems;

    public LadderGenerationResult(List<String> participants, List<LadderLine> ladderLines, int ladderWidth, List<String> matchingItems) {
        this.participants = participants;
        this.ladderLines = ladderLines;
        this.ladderWidth = ladderWidth;
        this.matchingItems = matchingItems;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public List<String> getMatchingItems() {
        return matchingItems;
    }
}
