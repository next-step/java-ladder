package ladder.step2.domain.strategy;

import ladder.step2.domain.Line;

public interface LineCreateStrategy {
    Line createLine(int countOfPlayers);
}
