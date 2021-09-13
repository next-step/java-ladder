package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Line> {
    private final Line[] lines;

    public Ladder(int width, int height) {
        this.lines = IntStream.range(0, width - 1)
            .mapToObj(unused -> new Line(height))
            .toArray(Line[]::new);
    }

    public void drawSteps(DrawStrategy drawStrategy) {
        for (int width = 0; width < lines.length; width++) {
            lines[width].drawSteps(drawStrategy, width == 0 ? null : lines[width - 1]);
        }
    }

    public int height() {
        return lines[0].height();
    }

    @Override
    public Iterator<Line> iterator() {
        return Arrays.stream(lines).iterator();
    }
}
