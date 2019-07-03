package ladder;

import java.util.Random;

public class BarGeneratorImpl implements BarGenerator{

    private Random random = new Random();

    @Override
    public boolean generateBar() {
        return random.nextBoolean();
    }
}
