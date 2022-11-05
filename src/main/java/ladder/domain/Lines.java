package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public static Lines from(int linesSize, int lineSize, LineGenerateStrategy strategy) {
        List<Line> result = new ArrayList<>();
        for (int i = 0; i < linesSize; i++) {
            result.add(Line.from(lineSize, strategy));
        }
        return new Lines(result);
    }
}
