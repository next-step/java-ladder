package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.dto.LadderDto;

public class LadderDtoFactory {

    public LadderDto create(Ladder ladder) {
        LadderResult ladderResult = ladder.simulate();
        return new LadderDto(
            ladder.getUsersNames(),
            ladder.getLadder(),
            ladder.getPrizes(),
            ladderResult.getStringValues()
        );
    }
}
