package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLinesGenerator implements LinesGenerator {
    private static final Random RANDOM = new Random();

    private Line lineGenerate(int rowCount) {
        List<Point> points = new ArrayList<>();

        Point point = Point.from(RANDOM.nextBoolean());
        points.add(point);

        for (int i = 0; i < rowCount - 1; i++) {
            Point next = point.next(RANDOM.nextBoolean());
            point = next;
            points.add(next);
        }

        return Line.from(points);
    }

    @Override
    public Lines generate(int rowCount, int colCount) {
        List<Line> lines = Stream.generate(() -> lineGenerate(rowCount))
                .limit(colCount)
                .collect(Collectors.toList());

        return Lines.from(lines);
    }
}
