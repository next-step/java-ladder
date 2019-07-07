package ladder.model;

import java.util.Random;

public class RandomConnector implements ConnectorStrategy {
    @Override
    public Direction generateNextConnection(Direction current) {
        if (current == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return new Random().nextBoolean() ? Direction.DOWN : Direction.RIGHT;
    }
}
