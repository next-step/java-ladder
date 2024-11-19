package nextstep.ladder.domain;

import nextstep.ladder.dto.LadderResult;

public class LadderParticipationResult {

    public LadderParticipationResult(Names names, LadderResult ladderResult) {
        validSameName(names, ladderResult);
    }

    private static void validSameName(Names names, LadderResult ladderResult) {
        if (!ladderResult.isSameSize(names)) {
            throw new IllegalArgumentException("이름과 결과는 동일한 길이여야 합니다");
        }
    }
}
