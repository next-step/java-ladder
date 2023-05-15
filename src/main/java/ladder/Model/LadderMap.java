package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class LadderMap {
    private final List<LadderLine> ladderLines = new ArrayList<>();

    public LadderMap(int numberOfPerson, int height) {
        for (int idx = 0; idx < height; idx++) {
            ladderLines.add(new LadderLine(numberOfPerson - 1));
        }
    }

    public List<LadderLine> ladderLines() {
        return ladderLines;
    }
}
