package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private final Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public boolean getRandomBoolean(boolean previousBoolean) {
        if (previousBoolean) {
            return false;
        }

        return random.nextBoolean();
    }

    public List<Boolean> getRandomBooleans(int count) {
        List<Boolean> list = new ArrayList<>();

        list.add(getRandomBoolean(false));

        for (int i = 1; i < count; i++) {
            list.add(i, this.getRandomBoolean(list.get(i - 1)));
        }

        return list;
    }
}
