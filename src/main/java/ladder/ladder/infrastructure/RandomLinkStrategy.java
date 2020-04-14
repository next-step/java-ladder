package ladder.ladder.infrastructure;

import ladder.ladder.domain.LinkStrategy;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {

    @Override
    public boolean get() {
        return new Random().nextBoolean();
    }
}
