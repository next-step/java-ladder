package ladder.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBooleanGenerator implements BooleanGenerator{

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean generate(){
        return random.nextBoolean();
    }
}
