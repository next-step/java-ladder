package ladder.domain.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLadder implements LadderStrategy {

    @Override
    public boolean isEnableLine() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextBoolean();
    }

}
