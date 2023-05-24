package nextstep.ladder.domain.engine;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Participants;

public interface Ladder {
    GameResult run(Participants participants, LadderResult result);
}
