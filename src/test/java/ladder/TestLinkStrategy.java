package ladder;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STRAIGHT;

import java.util.List;
import ladder.domain.Direction;
import ladder.strategy.LinkStrategy;

public class TestLinkStrategy implements LinkStrategy {

    @Override
    public List<Direction> link(int column) {
        return List.of(RIGHT, LEFT, RIGHT, LEFT, STRAIGHT);
    }
}
