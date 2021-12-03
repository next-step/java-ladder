package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLinesGenerator implements LinesGenerator {
    private static final Random RANDOM = new Random();
    private static final int MIN_COL_COUNT = 1;

    private Line lineGenerate(int rowCount) {
        List<Point> points = new ArrayList<>();

        Point point = Point.from(RANDOM.nextBoolean());
        points.add(point);

        for (int i = 1; i < rowCount - 1; i++) {
            Point next = point.next(RANDOM.nextBoolean());
            point = next;
            points.add(next);
        }

        return Line.from(points);
    }

    @Override
    public Lines generate(int rowCount, int colCount) {
        validateColCount(colCount);
        List<Line> lines = Stream.generate(() -> lineGenerate(rowCount))
                .limit(colCount)
                .collect(Collectors.toList());

        return Lines.from(lines);
    }

    @Override
    public void validateColCount(int colCount) {
        if (colCount < MIN_COL_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
