package ladder.dto;

import ladder.domain.user.LadderResult;

public class LadderResultResponseDto {
    private LadderResult ladderResult;

    private LadderResultResponseDto(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResultResponseDto of(LadderResult ladderResult) {
        return new LadderResultResponseDto(ladderResult);
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
