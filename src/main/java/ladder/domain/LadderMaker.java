package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    private final LinkGenerationStrategy linkGenerationStrategy;

    public LadderMaker(final LinkGenerationStrategy linkGenerationStrategy) {
        this.linkGenerationStrategy = linkGenerationStrategy;
    }

    public Ladder makeLadder(final int countOfLine, final int height) {
        Lines lines = new Lines();

        for (int i = 0; i < height; i++) {
            lines.append(makeLines(countOfLine));
        }

        return new Ladder(lines);
    }

    private List<Line> makeLines(final int countOfLine) {
        List<Line> lines = new ArrayList<>();
        Line line = Line.ofFirst(linkGenerationStrategy.isEnableToLink());
        lines.add(line);
        for (int i = 1; i < countOfLine - 1; i++) {
            line = Line.of(line.isRightLink(), linkGenerationStrategy.isEnableToLink());
            lines.add(line);
        }
        lines.add(Line.ofLast(line.isRightLink()));
        return lines;
    }
}
