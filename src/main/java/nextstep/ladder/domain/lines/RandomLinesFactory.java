package nextstep.ladder.domain.lines;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.lines.strategy.FirstLineCreationStrategy;
import nextstep.ladder.domain.lines.strategy.NextLineCreationStrategy;

public class RandomLinesFactory {

    private final FirstLineCreationStrategy firstLineCreationStrategy;
    private final NextLineCreationStrategy nextLineCreationStrategy;

    public RandomLinesFactory(FirstLineCreationStrategy firstLineCreationStrategy,
                              NextLineCreationStrategy nextLineCreationStrategy) {
        this.firstLineCreationStrategy = firstLineCreationStrategy;
        this.nextLineCreationStrategy = nextLineCreationStrategy;
    }

    public Lines createLines(int height, int participantCount) {
        List<Line> lines = new ArrayList<>();
        Line firstLine = firstLineCreationStrategy.createFirstLine(height);
        lines.add(firstLine);
        while (participantCount >= 2) {
            Line nextLine = nextLineCreationStrategy.createNextLine(firstLine, height);
            lines.add(nextLine);
            firstLine = nextLine;
            participantCount--;
        }
        return new Lines(lines);
    }
}
