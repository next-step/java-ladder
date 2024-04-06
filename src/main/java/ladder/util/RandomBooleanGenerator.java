package ladder.util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator{

    private final Random random = new Random();

    @Override
    public boolean generate(){
        return random.nextBoolean();
    }
}
