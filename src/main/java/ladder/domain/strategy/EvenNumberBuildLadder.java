package ladder.domain.strategy;

import java.util.LinkedList;
import java.util.List;

public class EvenNumberBuildLadder implements LineGeneratorStrategy {

    @Override
    public List<Boolean> generateLine(int countOfPerson) {
        List<Boolean> points = new LinkedList<>();
        for (int columnIndex = 0; columnIndex < countOfPerson - 1; columnIndex++) {
            if (isBuild(columnIndex)) {
                points.add(true);
                continue;
            }
            points.add(false);
        }
        return points;
    }

    private static boolean isBuild(int i) {
        return i % 2 == 0;
    }
}