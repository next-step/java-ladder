package ladder.controller.dto;

import ladder.service.dto.LadderGameResult;

import java.util.List;

public class LadderGameResponse {

    private final List<LadderLine> ladderLines;
    private final int ladderWidth;
    private final List<LadderGameResult> ladderGameResults;

    public LadderGameResponse(List<LadderLine> ladderLines, int ladderWidth, List<LadderGameResult> ladderGameResults) {
        this.ladderLines = ladderLines;
        this.ladderWidth = ladderWidth;
        this.ladderGameResults = ladderGameResults;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public List<LadderGameResult> getLadderGameResults() {
        return ladderGameResults;
    }
}
