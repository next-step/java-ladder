package nextstep.ladder.domain;

import nextstep.ladder.dto.CommaSeparatedResult;
import nextstep.ladder.dto.ResultDto;
import nextstep.ladder.interfaces.Position;

public class LadderParticipationResult {

    private final CommaSeparatedResult names;
    private final CommaSeparatedResult ladderResult;

    public LadderParticipationResult(CommaSeparatedResult names, CommaSeparatedResult ladderResults) {
        validSameName(names, ladderResults);
        this.names = names;
        this.ladderResult = ladderResults;
    }

    private static void validSameName(CommaSeparatedResult commaSeparatedResult, CommaSeparatedResult ladderResult) {
        if (!ladderResult.isSameSize(commaSeparatedResult)) {
            throw new IllegalArgumentException("이름과 결과는 동일한 길이여야 합니다");
        }
    }

    public ResultDto match(Position position) {
        return new ResultDto(
                position.match(names.getValuesByString(), ladderResult.getValuesByString()));
    }

    public int size() {
        return names.size();
    }

    public CommaSeparatedResult names() {
        return names;
    }

    public CommaSeparatedResult ladderResult() {
        return ladderResult;
    }
}
