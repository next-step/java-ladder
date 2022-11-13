package ladder.strategy;

import java.util.List;
import ladder.domain.PositiveInt;

public interface LinkStrategy {

    List<PositiveInt> link(final int column);
}
