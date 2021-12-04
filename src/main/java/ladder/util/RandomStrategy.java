package ladder.util;

import java.util.Random;
import java.util.function.Predicate;

public class RandomStrategy implements Predicate<Boolean> {
    private static final Random random = new Random();

    @Override
    public boolean test(Boolean value) {
        if (value || random.nextInt() % 2 == 0) {
            return false;
        }

        return true;
    }
}
