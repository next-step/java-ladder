package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomMakePointsStrategy implements MakePointsStrategy {

    private static final RandomMakePointsStrategy randomMakePointsStrategy = new RandomMakePointsStrategy();
    private static final Random random = new Random();

    public RandomMakePointsStrategy() {
    }

    @Override
    public List<Boolean> makePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson - 1).forEach(index -> points.add(makePoint(points, index)));
        return points;
    }

    private boolean makePoint(List<Boolean> points, int index) {
        return !isMakePointPossible(points, index) && random.nextBoolean();
    }

    private boolean isMakePointPossible(List<Boolean> points, int index) {
        return index > 0 && points.get(index - 1);
    }

    public static RandomMakePointsStrategy getInstance() {
        return randomMakePointsStrategy;
    }
}
