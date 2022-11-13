package ladder;

import java.util.List;
import ladder.domain.PositiveInt;
import ladder.strategy.LinkStrategy;

public class TestLinkStrategy implements LinkStrategy {

    @Override
    public List<PositiveInt> link(int column) {
        return List.of(PositiveInt.zero(), new PositiveInt(2));
    }
}
