package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int arrivalPoint(int startPoint) {
        int currentPoint = startPoint;
        for (Line line : lines) {
            currentPoint = line.move(currentPoint);
        }
        return currentPoint;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder make(int pointCount, int lineCount) {
        List<Line> ladderLine = new ArrayList<>();
        IntStream.range(0, lineCount)
                .forEach(line -> ladderLine.add(Line.init(pointCount)));
        return new Ladder(ladderLine);
    }
}
