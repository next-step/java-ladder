package ladder.domain.test;

import ladder.domain.MakePointsStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 일직선으로 결과 값이 나오도록 하는 Strategy (단, maximumLadderHeight이 짝수여야 성립함)
 */
public class ForceMakePointsStrategy implements MakePointsStrategy {

    private static final ForceMakePointsStrategy forceMakePointsStrategy = new ForceMakePointsStrategy();

    public ForceMakePointsStrategy() {
    }

    @Override
    public List<Boolean> makePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson - 1).forEach(index -> points.add(makePoint(points, index)));
        return points;
    }

    private boolean makePoint(List<Boolean> points, int index) {
        return !isMakePointPossible(points, index);
    }

    private boolean isMakePointPossible(List<Boolean> points, int index) {
        return index > 0 && points.get(index - 1);
    }

    public static ForceMakePointsStrategy getInstance() {
        return forceMakePointsStrategy;
    }
}
