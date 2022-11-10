package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int peopleCount, LadderPointGenerator ladderPointGenerator) {
        lines = initLine(height, peopleCount);
        ladderPointGenerator.generate(getLineSize(), maxLineCount(height, peopleCount), this::connectLineIfPossible);
    }

    private List<Line> initLine(int height, int peopleCount) {
        return IntStream.range(0, peopleCount)
                .mapToObj(person -> new Line(height))
                .collect(Collectors.toList());
    }

    private int maxLineCount(int height, int peopleCount) {
        return height * (peopleCount / 2);
    }

    private void connectLineIfPossible(int lineNumber) {
        Line line = getLine(lineNumber);
        Line rightLine = getLine(lineNumber + 1);
        Optional<Integer> pointIndex = getAvailablePoint(line, rightLine);
        if (pointIndex.isEmpty()) {
            return;
        }

        connectLine(line, rightLine, pointIndex.get());
    }

    private Optional<Integer> getAvailablePoint(Line line, Line rightLine) {
        List<Integer> lineEmptyPoints = line.emptyPoints();
        List<Integer> rightLineEmptyPoints = rightLine.emptyPoints();

        return lineEmptyPoints.stream()
                .filter(rightLineEmptyPoints::contains)
                .findAny();
    }

    private void connectLine(Line line, Line rightLine, int pointIndex) {
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
