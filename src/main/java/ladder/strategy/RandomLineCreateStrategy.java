package ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineCreateStrategy implements LineCreateStrategy {

    private final Random random;

    public RandomLineCreateStrategy(Random random) {
        this.random = random;
    }

    @Override
    public List<Boolean> build(int countOfPerson) {

        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i != 0 && points.get(i - 1)) {
                points.add(false);
                continue;
            }
            points.add(random.nextBoolean());
        }

        return points;
    }
}
