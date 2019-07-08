package ladder.domain;

import ladder.common.PositiveNumber;
import ladder.domain.model.LadderLines;

public interface LadderService {
    LadderLines createLadderLines(PositiveNumber conuntOfUsers, PositiveNumber height);
}
