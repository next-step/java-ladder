package nextstep.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private final List<Boolean> points;
    private final PointGenerator pointGenerator;

    public Line(int height, PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
        this.points = Stream.generate(pointGenerator::generatePoint)
                .limit(height)
                .collect(Collectors.toList());

        validatePoints();
    }

    private void validatePoints() {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .forEach(i -> points.set(i + 1, false));
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
