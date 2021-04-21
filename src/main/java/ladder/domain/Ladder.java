package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int with, int lineCount) {
        this.lines = make(with, lineCount);
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

    public List<Line> make(int with, int lineCount) {
        LineGeneratorFactory lineGeneratorFactory = new LineGeneratorFactory();
        return Stream.generate(() -> {
            LineGenerator lineGenerator = lineGeneratorFactory.lineGenerator();
            return lineGenerator.generate(with);
        }).limit(lineCount).collect(Collectors.toList());
    }
}
