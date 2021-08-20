package laddergame.strategy;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy{

    private static final Random random = new Random();

    @Override
    public boolean create() {
        return (random.nextInt(2) < 1);
    }
}
