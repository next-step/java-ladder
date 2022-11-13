package ladder;

import java.util.List;
import ladder.domain.PositiveInt;
import ladder.strategy.LinkStrategy;

public class TestLinkStrategy implements LinkStrategy {

    @Override
    public List<Integer> link(int column) {
        return List.of(0, 2);
    }
}
