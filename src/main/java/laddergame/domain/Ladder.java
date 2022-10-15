package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(int numberOfColumns, int height) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.from(numberOfColumns));
        }
        return new Ladder(lines);
    }

    public LadderLine getLine(int indexOfHeight) {
        return lines.get(indexOfHeight);
    }

    public int getHeight() {
        return lines.size();
    }

}
