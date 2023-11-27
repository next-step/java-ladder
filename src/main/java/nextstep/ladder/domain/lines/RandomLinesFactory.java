package nextstep.ladder.domain.lines;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.lines.strategy.FirstLineCreationStrategy;
import nextstep.ladder.domain.lines.strategy.LeftLineCreationStrategy;

public class RandomLinesFactory {

    private final FirstLineCreationStrategy firstLineCreationStrategy;
    private final LeftLineCreationStrategy leftLineCreationStrategy;

    public RandomLinesFactory(FirstLineCreationStrategy firstLineCreationStrategy,
                              LeftLineCreationStrategy leftLineCreationStrategy) {
        this.firstLineCreationStrategy = firstLineCreationStrategy;
        this.leftLineCreationStrategy = leftLineCreationStrategy;
    }

    public Lines createLines(int height, int participantCount) {
        List<Line> lines = new ArrayList<>();
        Line firstLine = firstLineCreationStrategy.createFirstLine(height);
        lines.add(firstLine);
        while (participantCount-- > 1) {
            lines.add(leftLineCreationStrategy.createLeftLine(firstLine, height));
        }
        return new Lines(lines);
    }
}
