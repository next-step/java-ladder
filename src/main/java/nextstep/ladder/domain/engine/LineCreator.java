package nextstep.ladder.domain.engine;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

public interface LineCreator {
    Ladder create(Participants participants, Height height);
}
