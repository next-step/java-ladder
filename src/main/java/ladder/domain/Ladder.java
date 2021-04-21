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
        this.lines = make2(with, lineCount);
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
        return Stream.generate(() -> Line.init(with))
                .limit(lineCount)
                .collect(Collectors.toList());
    }

    public List<Line> make2(int with, int lineCount) {
        LineGeneratorFactory lineGeneratorFactory = new LineGeneratorFactory();
        List<Line> lines = Stream.generate(() -> {
            LineGeneratorInterface lineGeneratorInterface = lineGeneratorFactory.lineGenerator();
            return lineGeneratorInterface.generate(with);
        }).limit(lineCount).collect(Collectors.toList());

        return lines;
    }
}
