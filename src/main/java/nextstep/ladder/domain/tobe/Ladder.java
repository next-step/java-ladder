package nextstep.ladder.domain.tobe;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final LineCreateStrategy LINE_CREATE_STRATEGY = new RandomLineCreateStrategy();
    private final List<Line> lines;

    public Ladder(int height, int width) {
        validateHeight(height);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, LINE_CREATE_STRATEGY));
        }
        this.lines = lines;
    }

    public void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("height is must more than " + MIN_HEIGHT);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
