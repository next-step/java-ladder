package ladder.domain;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    public static final int INIT_POSITION = 0;
    private final int countOfPoints;
    private final List<Line> lines;

    @Builder
    public Ladder(int countOfPoints, int countOfLines) {
            this.countOfPoints = countOfPoints;
            this.lines = generateLines(countOfLines);
    }

    private List<Line> generateLines(int linesCount) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, linesCount)
                .forEach(line -> lines.add(Line.valueOf(countOfPoints)));
        return lines;
    }

    public void drawLine(int linePosition, int columnPosition) {
        Line curLine = pickLine(linePosition);
        Line prevLine = pickLine(linePosition - 1);

        if (prevLine.hasLine(columnPosition)) {
            return;
        }
        curLine.draw(linePosition);
    }

    private Line pickLine(int linePosition) {
        return this.lines.get(getPositivePosition(linePosition));
    }

    private int getPositivePosition(int position) {
        return position < 0 ? INIT_POSITION : position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
