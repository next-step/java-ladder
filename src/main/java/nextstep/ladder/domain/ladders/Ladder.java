package nextstep.ladder.domain.ladders;

import nextstep.ladder.domain.result.Point;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private final List<Line> lines;

    public Ladder(int height, int width, LineCreateStrategy lineCreateStrategy) {
        validateHeight(height);
        this.lines = generateLines(height, width, lineCreateStrategy);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("height is must more than " + MIN_HEIGHT);
        }
    }

    private List<Line> generateLines(int height, int width, LineCreateStrategy lineCreateStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, lineCreateStrategy));
        }
        return lines;
    }

    public int getLastPosition(Point point) {
        lines.forEach(line -> line.move(point));
        return point.getIndex();
    }

    public List<Line> getLines() {
        return lines;
    }
}
