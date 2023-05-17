package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladderLines = new ArrayList<>();

    private final MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();

    public Ladder(int numberOfPerson, int height) {
        for (int idx = 0; idx < height; idx++) {
            ladderLines.add(new LadderLine(numberOfPerson - 1, makeLineStrategy));
        }
    }

    public List<LadderLine> ladderLines() {
        return ladderLines;
    }
}
