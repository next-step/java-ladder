package ladder.util;

import java.util.Random;
import java.util.function.Predicate;

public class RandomStrategy implements Predicate<Boolean> {
    @Override
    public boolean test(Boolean value) {
        if (value || new Random().nextInt() % 2 == 0) {
            return false;
        }

        return true;
    }
}
