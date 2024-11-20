package nextstep.ladder.domain;

import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.ResultDto;

public class LadderParticipationResult {

    private final CommaSeparatedResult commaSeparatedResult;
    private final CommaSeparatedResult ladderResult;

    public LadderParticipationResult(CommaSeparatedResult commaSeparatedResult, CommaSeparatedResult ladderResult) {
        validSameName(commaSeparatedResult, ladderResult);
        this.commaSeparatedResult = commaSeparatedResult;
        this.ladderResult = ladderResult;
    }

    private static void validSameName(CommaSeparatedResult commaSeparatedResult, CommaSeparatedResult ladderResult) {
        if (!ladderResult.isSameSize(commaSeparatedResult)) {
            throw new IllegalArgumentException("이름과 결과는 동일한 길이여야 합니다");
        }
    }

    public ResultDto match(Position position) {
        return new ResultDto(position.match(commaSeparatedResult.getNamesByString(), ladderResult.getNamesByString()));
    }
}
