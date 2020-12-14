package ladder.dto;

import ladder.domain.LadderGameResult;

import java.util.List;

public class LadderGameResultDto {
    private final LadderGameResult ladderGameResult;
    private final List<String> names;

    public LadderGameResultDto(LadderGameResult ladderGameResult, List<String> names) {
        this.ladderGameResult = ladderGameResult;
        this.names = names;
    }
}
