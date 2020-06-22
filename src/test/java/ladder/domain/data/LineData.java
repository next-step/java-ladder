package ladder.domain.data;

import ladder.domain.line.Line;
import ladder.domain.point.RandomPointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineData {

    public static List<Line> makeRandom(int count) {
        return Stream.generate(() -> Line.create(count, new RandomPointGenerator()))
                .limit(count)
                .collect(Collectors.toList());
    }
}
