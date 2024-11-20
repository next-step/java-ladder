package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.dto.ResultDto;

public class LadderParticipationResult {

    private final Names names;
    private final LadderResult ladderResult;

    public LadderParticipationResult(Names names, LadderResult ladderResult) {
        validSameName(names, ladderResult);
        this.names = names;
        this.ladderResult = ladderResult;
    }

    private static void validSameName(Names names, LadderResult ladderResult) {
        if (!ladderResult.isSameSize(names)) {
            throw new IllegalArgumentException("이름과 결과는 동일한 길이여야 합니다");
        }
    }

    public ResultDto match(Position position) {
        return new ResultDto(position.match(names.getNamesByString(), ladderResult.getResults()));
    }
}
