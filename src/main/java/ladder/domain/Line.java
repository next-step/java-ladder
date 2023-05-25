package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.request.LadderRequest;
import ladder.domain.strategy.GenerateStrategy;

public class Line {

    private final List<Boolean> points;

    public static Line from(LadderRequest request) {
        return new Line(request.getWidth(), request.getStrategy());
    }

    public Line(Width width, GenerateStrategy strategy) {
        this.points = generateLine(width, strategy);
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    private List<Boolean> generateLine(Width width, GenerateStrategy strategy) {
        List<Boolean> lines = new ArrayList<>();
        boolean before = false;

        for (int i = 0; i <= width.getWidthCount() - 1; i++) {
            boolean after = !before && strategy.makeLine();
            lines.add(after);
            before = after;
        }

        return lines;
    }

}
