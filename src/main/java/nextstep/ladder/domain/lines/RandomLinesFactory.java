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
        Line firstLine = lineCreationStrategy.createNextLine(createFirstLine(), height);
        lines.add(firstLine);
        while (participantCount >= 2) {
            Line nextLine = lineCreationStrategy.createNextLine(firstLine, height);
            lines.add(nextLine);
            firstLine = nextLine;
            participantCount--;
        }
        return new Lines(lines);
    }

    private Line createFirstLine() {
        return Line.createLineWithPointStatus(Collections.emptyList());
    }
}
