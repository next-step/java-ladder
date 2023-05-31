package ladder.domain.test;

import ladder.domain.MakePointsStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 연속된 가로줄이 있게 만드는 Strategy
 */
public class FailedMakePointsStrategy implements MakePointsStrategy {

    private static final FailedMakePointsStrategy failedMakePointsStrategy = new FailedMakePointsStrategy();

    public FailedMakePointsStrategy() {
    }

    @Override
    public List<Boolean> makePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson - 1).forEach(index -> points.add(true));
        return points;
    }

    public static FailedMakePointsStrategy getInstance() {
        return failedMakePointsStrategy;
    }
}
