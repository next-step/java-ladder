package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    static List<Line> first(int height) {
        List<Line> firstLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            firstLadderLine.add(new Line(i, new RandomLinkable().get()));
        }
        return firstLadderLine;
    }

    static List<Line> last(int height) {
        List<Line> lastLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lastLadderLine.add(new Line(i, false));
        }
        return lastLadderLine;
    }

    static List<Line> normal(int height, LadderLine beforeLadderLine) {
        return beforeLadderLine.newLineOnBeforeLine(height);
    }
}
