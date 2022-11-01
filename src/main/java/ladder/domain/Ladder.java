package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int peopleCount, LadderPointGenerator ladderPointGenerator) {
        lines = initLine(height, peopleCount);
        ladderPointGenerator.generate(this, maxLineCount(height, peopleCount));
    }

    private List<Line> initLine(int height, int peopleCount) {
        return IntStream.range(0, peopleCount)
                .mapToObj(person -> new Line(height))
                .collect(Collectors.toList());
    }

    private int maxLineCount(int height, int peopleCount) {
        return height * (peopleCount / 2);
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
