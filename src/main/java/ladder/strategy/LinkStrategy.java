package ladder.strategy;

import java.util.List;
import ladder.domain.Direction;

public interface LinkStrategy {

    List<Direction> link(final int column);
}
