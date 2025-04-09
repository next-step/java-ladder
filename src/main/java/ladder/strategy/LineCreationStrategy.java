package ladder.strategy;

import java.util.List;

public interface LineCreationStrategy {
    List<Boolean> hasHorizontalLine(int countOfPersons);
}
