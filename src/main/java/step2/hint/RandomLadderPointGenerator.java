package step2.hint;

import java.util.Random;

public class RandomLadderPointGenerator implements LadderPointGenerator {
    private static final Random random = new Random();


    @Override
    public boolean generatePoint() {
        return random.nextBoolean();
    }
}
