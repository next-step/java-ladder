package ladder.Model;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final ArrayList<Boolean> ladderHorizonLine = new ArrayList<>();
    private final ArrayList<Boolean> ladderVerticalLine = new ArrayList<>();

    public LadderLine(int width, MakeLineStrategy makeLineStrategy) {
        Boolean made = false;

        for (int idx = 0; idx < width; idx++) {
            ladderVerticalLine.add(true);
            made = makeLineStrategy.makeLine(made);
            ladderHorizonLine.add(made);
        }

        ladderVerticalLine.add(true);
    }

    public List<Boolean> horizonLines() {
        return ladderHorizonLine;
    }

    public List<Boolean> verticalLines() {
        return ladderVerticalLine;
    }

    public int size() {
        return ladderHorizonLine.size();
    }

}
