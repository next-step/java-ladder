package reladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }
}
