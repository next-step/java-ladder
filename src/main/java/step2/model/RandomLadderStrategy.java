package step2.model;

import java.util.Random;

public class RandomLadderStrategy implements LadderStrategy{
    @Override
    public boolean generateLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
