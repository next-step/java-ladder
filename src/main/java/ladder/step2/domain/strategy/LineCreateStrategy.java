package ladder.step2.domain.strategy;

import java.util.List;

public interface LineCreateStrategy {
    void addPartLine(List<Boolean> partLines, int countOfPlayers);
}
