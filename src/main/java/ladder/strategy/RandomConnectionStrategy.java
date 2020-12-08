package ladder.strategy;

import java.util.Random;

/**
 * Created By mand2 on 2020-12-07.
 */
public class RandomConnectionStrategy implements ConnectionStrategy {

    private final static Random RANDOM = new Random();

    @Override
    public boolean hasConnected() {
        return RANDOM.nextBoolean();
    }
}
