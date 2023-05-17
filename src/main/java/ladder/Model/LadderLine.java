package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final ArrayList<Boolean> ladderLine = new ArrayList<>();

    public LadderLine(int width, MakeLineStrategy makeLineStrategy) {
        Boolean made = false;

        for (int idx = 0; idx < width; idx++) {
            made = makeLineStrategy.makeLine(made);
            ladderLine.add(made);
        }
    }

    public List<Boolean> lines() {
        return ladderLine;
    }
}
