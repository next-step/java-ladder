package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
        AtomicInteger currentPoint = new AtomicInteger(startPoint);
        lines.forEach(line -> currentPoint.set(line.move(currentPoint.get())));

        return currentPoint.get();
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
