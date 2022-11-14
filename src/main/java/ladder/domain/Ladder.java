package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final LadderConnectDecider ladderConnectDecider;

    public Ladder(int height, int peopleCount, LadderConnectDecider ladderConnectDecider) {
        validate(height);
        this.ladderConnectDecider = ladderConnectDecider;
        lines = initLine(height, peopleCount);
        buildLadder(height);
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1 보다 커야 합니다.");
        }
    }

    private List<Line> initLine(int height, int peopleCount) {
        return IntStream.range(0, peopleCount)
                .mapToObj(person -> new Line(height))
                .collect(Collectors.toList());
    }

    private void buildLadder(int height) {
        for (int i = 0; i < height; i++) {
            connectFloor();
        }
    }

    private void connectFloor() {
        for (int lineNumber = 0; lineNumber < getLineSize() - 1; lineNumber++) {
            connectLineIfPossible(lineNumber);
        }
    }

    private void connectLineIfPossible(int lineNumber) {
        if (!ladderConnectDecider.decide()) {
            return;
        }
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
                .findFirst();
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
