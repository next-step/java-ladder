package reladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = new ArrayList<>(ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }

    public int move(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.move(index);
        }
        return index;
    }
}
