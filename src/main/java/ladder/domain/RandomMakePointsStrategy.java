package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomMakePointsStrategy implements MakePointsStrategy {

    private final Random random = new Random();

    @Override
    public List<Boolean> makePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson - 1).forEach(index -> points.add(makePoint(points, index)));
        return points;
    }

    private boolean makePoint(List<Boolean> points, int index) {
        return validateMakePointIsPossible(points, index) ? false : random.nextBoolean();
    }

    private boolean validateMakePointIsPossible(List<Boolean> points, int index) {
        return index > 0 && points.get(index - 1);
    }
}
