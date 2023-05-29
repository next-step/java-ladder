package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.GenerateStrategy;

public class Line {

    private final List<Boolean> points;

    public static Line from(Width width, GenerateStrategy strategy) {
        return new Line(width, strategy);
    }

    public Line(Width width, GenerateStrategy strategy) {
        this.points = generateLine(width, strategy);
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    public int getSize() {
        return this.points.size();
    }

    private List<Boolean> generateLine(Width width, GenerateStrategy strategy) {
        List<Boolean> lines = new ArrayList<>();
        boolean before = false;

        for (int i = 0; i < width.getWidthSize(); i++) {
            boolean after = !before && strategy.generateBoolean();
            lines.add(after);
            before = after;
        }

        return lines;
    }

}
