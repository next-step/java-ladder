package nextstep.ladder.dto;

import nextstep.ladder.domain.LadderGameInfo;
import nextstep.ladder.domain.LadderLine;

import java.util.List;

public class LadderResponseDto {
    private List<LadderLine> ladderLines;
    private LadderGameInfo ladderGameInfo;

    public LadderResponseDto(List<LadderLine> ladderLines, LadderGameInfo ladderGameInfo) {
        this.ladderLines = ladderLines;
        this.ladderGameInfo = ladderGameInfo;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }
}
