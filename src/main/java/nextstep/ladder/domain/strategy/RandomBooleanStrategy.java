package nextstep.ladder.domain.strategy;


import java.util.Random;

public class RandomBooleanStrategy implements BooleanStrategy {
    private static final Random random = new Random();

    @Override
    public boolean decide(int index) {
        return random.nextBoolean();
    }
}
