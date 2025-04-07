package ladder.domain;

import java.util.Set;

public interface RowGenerator {
    Set<Bridge> generate(int playerCount);
}
