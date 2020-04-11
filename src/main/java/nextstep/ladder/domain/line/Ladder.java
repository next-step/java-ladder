package nextstep.ladder.domain.line;

import nextstep.ladder.domain.game.LadderSize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<LadderLine> {
    private List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }
    public Ladder(LadderSize ladderSize) {
        ladderLines = new ArrayList<>();
        for (int i = 0, size = ladderSize.getHeight(); i < size; i++) {
            ladderLines.add(LadderLine.valueOf(ladderSize.getWidth()));
        }
    }

    public int getHeight() {
        return ladderLines.size();
    }

    public int getEndPointIndex(int startPointIndex) {
        int nextIndex = startPointIndex;
        for (LadderLine ladderLine : ladderLines) {
            nextIndex = ladderLine.move(nextIndex);
        }

        return nextIndex;
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return ladderLines.iterator();
    }
}
