package nextstep.ladder.strategy;

import java.util.Random;

public class RandomDrawLineStrategy implements DrawLineStrategy {

    private RandomDrawLineStrategy(){}

    private final Random random = new Random();

    public static RandomDrawLineStrategy getInstance(){
        return RandomLineStrategyHolder.instance;
    }

    @Override
    public boolean draw() {
        return random.nextBoolean();
    }

    private static class RandomLineStrategyHolder {
        private static final RandomDrawLineStrategy instance =  new RandomDrawLineStrategy();
    }
}
