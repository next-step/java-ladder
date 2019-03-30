package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultLineGenerator implements LineGenerator {

    @Override
    public Line generate(int lineSize) {
        List<Boolean> points = new ArrayList<>(lineSize);

        while (!points.contains(true)) {
            points = this.generatePoints(lineSize);
        }

        return new Line(points);
    }

    private List<Boolean> generatePoints(int lineSize) {
        List<Boolean> points = Stream
            .generate(() -> Math.round(Math.random()) == 1)
            .limit(lineSize)
            .collect(Collectors.toList());

        return points;
    }
}
