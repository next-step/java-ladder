package ladder.domain;

import ladder.common.PositiveNumber;
import ladder.domain.ladderline.LadderLines;

@FunctionalInterface
public interface LadderLineFactory {
    LadderLines create(PositiveNumber countOfUsers, PositiveNumber height);
}
