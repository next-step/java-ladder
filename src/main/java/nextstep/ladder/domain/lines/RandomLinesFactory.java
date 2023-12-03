package nextstep.ladder.domain.lines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.lines.strategy.line.LineCreationStrategy;

public class RandomLinesFactory {
    private final LineCreationStrategy lineCreationStrategy;

    public RandomLinesFactory(LineCreationStrategy lineCreationStrategy) {
        this.lineCreationStrategy = lineCreationStrategy;
    }

    public Lines createLines(int height, int participantCount) {
        List<Line> lines = new ArrayList<>();
        Line firstLine = createFirstLine(height);
        lines.add(firstLine);
        while (participantCount >= 2) {
            Line nextLine = createNextLine(height, firstLine);
            lines.add(nextLine);
            firstLine = nextLine;
            participantCount--;
        }
        return new Lines(lines);
    }

    private Line createFirstLine(int height) {
        return lineCreationStrategy.createNextLine(createFirstLine(), height);
    }

    private Line createNextLine(int height, Line firstLine) {
        return lineCreationStrategy.createNextLine(firstLine, height);
    }

    private Line createFirstLine() {
        return Line.createLineWithPointStatus(Collections.emptyList());
    }
}
