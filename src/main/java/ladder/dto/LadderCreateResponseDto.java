package ladder.dto;


import ladder.common.Csv;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.user.LadderUsers;

public class LadderCreateResponseDto {
    private LadderUsers ladderUsers;
    private LadderLines ladderLines;
    private Csv ladderResults;

    private LadderCreateResponseDto(LadderUsers ladderUsers, LadderLines ladderLines, Csv ladderResults) {
        this.ladderUsers = ladderUsers;
        this.ladderLines = ladderLines;
        this.ladderResults = ladderResults;
    }

    public static LadderCreateResponseDto of(LadderUsers ladderUsers, LadderLines ladderLines, Csv ladderResults) {
        return new LadderCreateResponseDto(ladderUsers, ladderLines, ladderResults);
    }

    public LadderUsers getLadderUsers() {
        return ladderUsers;
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }

    public Csv getLadderResults() {
        return ladderResults;
    }
}
