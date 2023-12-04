package nextstep.ladder.domain.lines;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Point;

public class Lines {

    public static final String LINES_COUNT_EXCEPTION = "줄이 1개면 사다리를 생성할 수 없습니다.";
    public static final int MIN_SIZE = 1;
    public static final String LINES_EMPTY_EXCEPTION = "lines가 존재하지 않습니다.";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    private void validateLines(List<Line> lines) {
        validateEmpty(lines);
        validateLinesCount(lines);
        validateSameLength(lines);
        validateLineOverlapping(lines);
    }

    private void validateEmpty(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(LINES_EMPTY_EXCEPTION);
        }
    }

    private void validateLinesCount(List<Line> lines) {
        if (isMinimumSize(lines)) {
            throw new IllegalStateException(LINES_COUNT_EXCEPTION);
        }
    }

    private boolean isMinimumSize(List<Line> lines) {
        return lines.size() <= MIN_SIZE;
    }

    public void validateSameLength(List<Line> lines) {
        Line normLine = lines.get(0);
        lines.forEach(normLine::validateSameSizeAs);
    }

    public void validateLineOverlapping(List<Line> lines) {
        lines.stream()
                .skip(1)
                .reduce(lines.get(0), (targetLine, nextLine) -> {
                    targetLine.isOverlapping(nextLine);
                    return nextLine;
                });
    }

    public List<Line> getLines() {
        return lines;
    }

    public Participant startGame(Participant participant, int startPosition, int currentHeight) {
        if (startPosition == this.lines.size()) {
            CurrentLadderPosition currentLadderPosition = startWithLastLine();
            return startWithNormalLine(new Participant(participant.getName() , currentLadderPosition.getPosition()), currentLadderPosition.getPosition(),
                    currentLadderPosition.getHeight());
        }

        return startWithNormalLine(participant, startPosition, currentHeight);
    }

    private Participant startWithNormalLine(Participant participant, int startPosition, int currentHeight) {
        int maxHeight = this.lines.get(0).getMaxHeight();
        int currentPosition = startPosition;
        while (currentHeight < maxHeight) {
            int dir = moveDir(currentPosition, currentHeight);
            participant.move(dir);
            currentPosition += dir;
            currentHeight++;
        }
        return participant;
    }

    private CurrentLadderPosition startWithLastLine() {
        int maxHeight = this.lines.get(0).getMaxHeight();
        int currentHeight = 0;
        int currentPosition = this.lines.size();

        while (currentHeight < maxHeight) {
            if (findPoint(currentPosition, currentHeight)) {
                return new CurrentLadderPosition(currentPosition - 1, currentHeight + 1);
            }
            currentHeight++;
        }
        return new CurrentLadderPosition(currentPosition, maxHeight);
    }

    private boolean findPoint(int currentPosition, int currentHeight) {
        Point leftPoint = Optional.ofNullable(lines.get(currentPosition - 1))
                .map(line -> line.horizontalLine(currentHeight))
                .orElse(Point.NOTHING);
        return leftPoint.movable();
    }

    private int moveDir(int currentPosition, int currentHeight) {
        Line currentLine = lines.get(currentPosition);
        if (currentLine.ableToMoveSideWay(currentHeight)) {
            return 1;
        }

        int beforePosition = getBeforePosition(currentPosition);
        Point leftPoint = Optional.ofNullable(lines.get(beforePosition))
                .map(line -> line.horizontalLine(currentHeight))
                .orElse(Point.NOTHING);
        if (leftPoint.movable()) {
            return -1;
        }

        return 0;
    }

    private int getBeforePosition(int currentPosition) {
        if (currentPosition == 0 || currentPosition > this.lines.size()) {
            return 0;
        }
        return currentPosition - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
