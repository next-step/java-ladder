package nextstep.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public final List<LadderLine> ladderLines;

    public Ladder(int ladderCount, String[] names) {
        this.ladderLines = new ArrayList<>();
        for (int i = 0; i < ladderCount; i++) {
            ladderLines.add(LadderLine.init(names.length));
        }
    }

    public List<LadderLine> ladderLines() {
        return ladderLines;
    }
}
