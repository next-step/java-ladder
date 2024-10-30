package nextstep.ladder.domain.strategy;


import java.util.Random;

public class RandomBoolean implements BooleanStrategy {
    private static final Random random = new Random();

    @Override
    public boolean decide() {
        return random.nextBoolean();
    }
}
