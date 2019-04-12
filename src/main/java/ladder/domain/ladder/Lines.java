package ladder.domain.ladder;

import ladder.vo.LadderLocation;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private static final int NUMBER_OF_UNIQUE_LINE_SIZE = 1;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateLines(lines);

        this.lines = lines;
    }

    @Override
    public String toString() {
        return this.lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    LadderLocation cross(LadderLocation location) {
        int currentFloor = location.getFloor();
        int indexOfLine = getIndexOfLine(currentFloor);

        int movedIndex = this.lines.get(indexOfLine).move(location.getIndex());
        return new LadderLocation(movedIndex, currentFloor - 1);
    }

    int getSize() {
        return this.lines.get(0).getSize();
    }

    int getHeight() {
        return this.lines.size();
    }

    private void validateLines(List<Line> lines) {
        if (NUMBER_OF_UNIQUE_LINE_SIZE != getNumberOfUniqueWidths(lines)) {
            throw new IllegalArgumentException("Every line must has the same size");
        }
    }

    private long getNumberOfUniqueWidths(List<Line> lines) {
        return lines.stream()
                .map(Line::getSize)
                .distinct()
                .count();
    }

    private int getIndexOfLine(int floor) {
        return this.lines.size() - floor;
    }
}
