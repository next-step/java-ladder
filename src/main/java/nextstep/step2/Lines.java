package nextstep.step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;
    private final int height;

    public Lines(int height, int width, PointGenerator pointGenerator) {
        this.lines = Stream.concat(
                Stream.iterate(new Line(height, pointGenerator), prev -> new Line(height, prev, pointGenerator))
                        .limit(width - 1),
                Stream.of(Line.generateEndLine(height))
        ).collect(Collectors.toList());
        this.height = height;
    }

    public int getWidth() {
        return lines.size();
    }

    public int getHeight() {
        return height;
    }

    public boolean isConnected(int x, int y) {
        if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
            return false;
        }
        return lines.get(x).isConnected(y);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
