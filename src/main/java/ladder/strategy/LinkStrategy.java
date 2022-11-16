package ladder.strategy;

import java.util.List;
import ladder.domain.PositiveInt;

public interface LinkStrategy {

    List<Integer> link(final int column);
}
