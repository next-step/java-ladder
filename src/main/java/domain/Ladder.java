package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final LadderLines ladderLines;

    private Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = new LadderLines(ladderLines);
    }

    public static Ladder init(final int ladderHeight, final int numberOfPeople) {
        List<LadderLine> ladder = new ArrayList<>();
        for(int i = 0; i < ladderHeight; i++) {
            ladder.add(LadderLine.init(numberOfPeople));
        }

        return new Ladder(ladder);
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }

    public int move(int index) {
        for(int i = 0, size = ladderLines.size(); i < size; i++) {
            index = ladderLines.get(i).move(index);
        }

        return index;
    }
}
