package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.LadderStrategy;

public class Line {

    private final List<Boolean> points;

    public Line(Width width, LadderStrategy strategy) {
        this.points = generateLine(width, strategy);
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    private List<Boolean> generateLine(Width width, LadderStrategy strategy) {
        return lineValidate(Stream.generate(strategy::makeLine)
                .limit(width.getWidthCount())
                .collect(Collectors.toList()));
    }

    private List<Boolean> lineValidate(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            previousHasBridge(points, i);
        }

        return points;
    }

    private static void previousHasBridge(List<Boolean> points, int i) {
        if (points.get(i) == points.get(i + 1)) {
            points.set(i + 1, false);
        }
    }

    public static Line from(LadderRequest request) {
        return new Line(request.getWidth(), request.getStrategy());
    }

}
