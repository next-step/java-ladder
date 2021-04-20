package ladder.controller.dto;

import ladder.service.dto.LadderGameResult;

import java.util.List;

public class LadderGameResponse {

    private final LadderGenerationResult ladderGenerationResult;
    private final List<LadderGameResult> ladderGameResults;

    public LadderGameResponse(LadderGenerationResult ladderGenerationResult, List<LadderGameResult> ladderGameResults) {
        this.ladderGenerationResult = ladderGenerationResult;
        this.ladderGameResults = ladderGameResults;
    }

    public LadderGenerationResult getLadderGenerationResult() {
        return ladderGenerationResult;
    }

    public List<LadderGameResult> getLadderGameResults() {
        return ladderGameResults;
    }
}
