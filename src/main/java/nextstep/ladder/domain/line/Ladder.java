package nextstep.ladder.domain.line;

import nextstep.ladder.domain.game.LadderSize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<LadderLine> {
    private List<LadderLine> ladder;

    public Ladder(LadderSize ladderSize) {
        ladder = generateHorizontalLines(ladderSize);
    }

    private List<LadderLine> generateHorizontalLines(
            LadderSize ladderSize) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0, size = ladderSize.getHeight(); i < size; i++) {
            ladderLines.add(LadderLine.init(ladderSize.getWidth()));
        }

        return ladderLines;
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getEndPointIndex(int startPointIndex) {
        int nextIndex = startPointIndex;
        for (LadderLine ladderLine : ladder) {
            nextIndex = ladderLine.move(nextIndex);
        }

        return nextIndex;
    }

    @Override
    public Iterator<LadderLine> iterator() {
        return ladder.iterator();
    }
}
