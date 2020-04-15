package ladder.ladder.domain;

import ladder.ladder.infrastructure.RandomLinkStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLineGenerator {

    private LadderLineGenerator() {
    }

    static LadderLine generateFirstLine(int height) {
        List<Line> firstLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            firstLadderLine.add(Line.of(i, new RandomLinkStrategy().get()));
        }
        return LadderLine.of(firstLadderLine);
    }

    static LadderLine generateInnerLine(LadderLine ladderLine, int height) {
        List<Line> innerLadderLine = new ArrayList<>();
        List<Line> innerLines = ladderLine.getLines();
        for (int i = 0; i < height; i++) {
            Line newLineBasedPrevLine = Line.generateLineBasedPrevLine(innerLines.get(i), new RandomLinkStrategy().get());
            innerLadderLine.add(newLineBasedPrevLine);
        }
        return LadderLine.of(innerLadderLine);
    }

    static LadderLine generateLastLine(int height) {
        List<Line> lastLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lastLadderLine.add(Line.of(i, false));
        }
        return LadderLine.of(lastLadderLine);
    }


}
