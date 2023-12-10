package ladder.gilbert;

import java.util.Random;

public class GilbertRandomBooleanGenerator implements BooleanGenerator {

    @Override
    public boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
