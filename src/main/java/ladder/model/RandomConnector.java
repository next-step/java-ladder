package ladder.model;

import java.util.Random;

public class RandomConnector implements ConnectorStrategy {
    @Override
    public boolean isConnectedToRight() {
        return new Random().nextBoolean();
    }
}
