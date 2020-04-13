package ladder.ladder.domain;

import ladder.ladder.infrastructure.RandomLinkStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLineGenerator {
    private static final int FIRST = 1;

    private LadderLineGenerator() {
    }

    public static List<LadderLine> generate(int height, int width) {
        List<LadderLine> allLines = new ArrayList<>();
        allLines.add(generateFirstLine(height));
        int lineCountExceptFirstLine = Math.subtractExact(width, FIRST);

        for (int i = FIRST; i < lineCountExceptFirstLine; i++) {
            int prevIndex = Math.subtractExact(i, FIRST);
            allLines.add(generateInnerLine(height, allLines.get(prevIndex)));
        }
        allLines.add(generateLastLine(height));
        return allLines;
    }

    private static LadderLine generateFirstLine(int height) {
        List<Line> firstLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            firstLadderLine.add(Line.of(i, new RandomLinkStrategy().get()));
        }
        return LadderLine.of(firstLadderLine);
    }

    private static LadderLine generateInnerLine(int height, LadderLine ladderLine) {
        List<Line> innerLadderLine = new ArrayList<>();
        List<Line> innerLines = ladderLine.getLines();
        for (int i = 0; i < height; i++) {
            RandomLinkStrategy randomLinkStrategy = new RandomLinkStrategy();
            Line newLineBasedPrevLine = Line.generateLineBasedPrevLine(innerLines.get(i), randomLinkStrategy.get());
            innerLadderLine.add(newLineBasedPrevLine);
        }
        return LadderLine.of(innerLadderLine);
    }

    private static LadderLine generateLastLine(int height) {
        List<Line> lastLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lastLadderLine.add(Line.of(i, false));
        }
        return LadderLine.of(lastLadderLine);
    }

}
