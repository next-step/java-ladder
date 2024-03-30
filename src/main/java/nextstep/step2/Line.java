package nextstep.step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private final List<Boolean> points;
    private PointGenerator pointGenerator;

    public Line(int height, PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
        this.points = Stream.generate(pointGenerator::generatePoint)
                .limit(height)
                .collect(Collectors.toList());
    }

    public Line(int height, Line prev, PointGenerator pointGenerator) {
        this.points = IntStream.range(0, height)
                .mapToObj(index -> pointGenerator.generatePoint() && !prev.getPoints().get(index))
                .collect(Collectors.toList());
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
