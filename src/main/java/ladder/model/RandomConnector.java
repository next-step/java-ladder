package ladder.model;

import java.util.Random;

public class RandomConnector implements ConnectorStrategy {
    @Override
    public boolean generateConnection(boolean before) {
        if (before) {
            return false;
        }
        return new Random().nextBoolean();
    }
}
