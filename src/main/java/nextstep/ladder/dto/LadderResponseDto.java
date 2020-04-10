package nextstep.ladder.dto;

import nextstep.ladder.domain.*;

import java.util.List;

public class LadderResponseDto {
    private Ladder ladder;
    private LadderGameInfo ladderGameInfo;

    public LadderResponseDto(Ladder ladder, LadderGameInfo ladderGameInfo) {
        this.ladder = ladder;
        this.ladderGameInfo = ladderGameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }
}
