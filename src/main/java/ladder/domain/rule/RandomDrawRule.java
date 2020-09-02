package ladder.domain.rule;

import java.util.Random;

public class RandomDrawRule implements DrawRule {
    private static Random random = new Random();

    @Override
    public boolean isDrawable() {
        return random.nextBoolean();
    }
}
