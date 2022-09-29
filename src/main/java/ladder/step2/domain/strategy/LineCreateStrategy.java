package ladder.step2.domain.strategy;

import ladder.step2.domain.PartLine;

import java.util.List;

public interface LineCreateStrategy {
    List<PartLine> addPartLine(int countOfPlayers);
}
