package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifficultyLevelLineGenerator implements LineGenerator {
    private DifficultyLevel difficultyLevel;

    public DifficultyLevelLineGenerator(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public List<Point> createPoints(int lineSize) {
        List<Point> points = new ArrayList<>(lineSize);

        // first
        points.add(Point.first(difficultyLevel.generateMovableFrom(Math.random() <= 0.5)));

        // middle
        IntStream.rangeClosed(1, lineSize - 1)
                .mapToObj(i -> points.add(points.get(i - 1).next(difficultyLevel.generateMovableFrom(points.get(i-1).hasMoveDirection()))))
                .collect(Collectors.toList());

        // last
        points.add(points.get(lineSize - 1).last());

        return points;
    }
}
