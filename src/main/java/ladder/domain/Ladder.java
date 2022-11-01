package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private final List<Line> lines;

    public Ladder(int height, int peopleCount) {
        this.height = height;
        lines = IntStream.range(0, peopleCount)
                .mapToObj(person -> new Line(height))
                .collect(Collectors.toList());
        buildPoints(peopleCount);
    }

    private void buildPoints(int lineCount) {
        Random random = new Random();
        for (int i = 0; i < lineCount; i++) {
            int lineNumber = random.nextInt(lines.size() - 1);
            Line line = lines.get(lineNumber);
            Line rightLine = lines.get(lineNumber + 1);

            Optional<Integer> pointIndex = getAvailablePoint(line, rightLine);
            if (pointIndex.isEmpty()) {
                // TODO: 좀더 나은 처리
                continue;
            }

            connectLine(line, rightLine, pointIndex.get());
        }
    }

    private Optional<Integer> getAvailablePoint(Line line, Line rightLine) {
        List<Integer> lineEmptyPoints = line.emptyPoints();
        List<Integer> rightLineEmptyPoints = rightLine.emptyPoints();

        return lineEmptyPoints.stream()
                .filter(rightLineEmptyPoints::contains)
                .findFirst();
    }

    private void connectLine(Line line, Line rightLine, int pointIndex) {
        line.setPoint(pointIndex, Point.RIGHT);
        rightLine.setPoint(pointIndex, Point.LEFT);
    }
}
