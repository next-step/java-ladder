package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int peopleCount, LadderPointGenerator ladderPointGenerator) {
        lines = IntStream.range(0, peopleCount)
                .mapToObj(person -> new Line(height))
                .collect(Collectors.toList());
        ladderPointGenerator.generate(this, peopleCount);
    }

    public void connectLine(Line line, Line rightLine, int pointIndex) {
        line.setPoint(pointIndex, Point.RIGHT);
        rightLine.setPoint(pointIndex, Point.LEFT);
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int getLineSize() {
        return lines.size();
    }
}
