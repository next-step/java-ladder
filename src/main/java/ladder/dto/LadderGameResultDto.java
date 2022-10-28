package ladder.dto;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.result.Results;

public class LadderGameResultDto {

    private final LadderLines ladderLines;
    private final Results results;

    public LadderGameResultDto(Results results, LadderLines ladderLines) {
        this.ladderLines = ladderLines;
        this.results = results;
    }

    public LadderLines ladderLines() {
        return ladderLines;
    }

    public Results results() {
        return results;
    }
}
