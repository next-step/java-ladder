package ladder.dto;

import ladder.common.Csv;
import ladder.common.PositiveNumber;

public class LadderCreateRequestDto {
    private Csv ladderUsers;
    private Csv ladderResults;
    private PositiveNumber ladderHeight;

    private LadderCreateRequestDto(Csv ladderUsers, Csv ladderResults, PositiveNumber ladderHeight) {
        this.ladderUsers = ladderUsers;
        this.ladderResults = ladderResults;
        this.ladderHeight = ladderHeight;
    }

    public static LadderCreateRequestDto of(Csv ladderUsers, Csv ladderResults, PositiveNumber ladderHeight) {
        return new LadderCreateRequestDto(ladderUsers, ladderResults, ladderHeight);
    }

    public Csv getLadderUsers() {
        return ladderUsers;
    }

    public Csv getLadderResults() {
        return ladderResults;
    }

    public PositiveNumber getLadderHeight() {
        return ladderHeight;
    }
}
