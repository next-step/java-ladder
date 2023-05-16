package ladder.Model;

import java.util.ArrayList;

public class LadderLine {

    private final MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();

    private final ArrayList<Boolean> ladderLine = new ArrayList<>();

    public LadderLine(int width) {
        Boolean made = false;

        for (int idx = 0; idx < width; idx++) {
            made = makeLineStrategy.MakeLine(made);
            ladderLine.add(made);
        }
    }

    public ArrayList<Boolean> lines() {
        return ladderLine;
    }
}
