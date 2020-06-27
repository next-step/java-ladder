package step4.strategy;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy{

    Random random = new Random();

    @Override
    public boolean hasLine() {
        return random.nextBoolean();
    }

}
