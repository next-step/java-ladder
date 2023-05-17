package step2.domain;

import java.util.ArrayList;

public class LadderGenerator {

    private final BridgeBuildStrategy bridgeBuildStrategy;

    public LadderGenerator(BridgeBuildStrategy bridgeBuildStrategy) {
        this.bridgeBuildStrategy = bridgeBuildStrategy;
    }

    public Ladder buildBridges(Ladder ladder) {
        ArrayList<Line> lines = ladder.getLines();
        for (int lineNumber = 0; lineNumber < ladder.getWidth()-1; lineNumber++) {
            buildBridge(lines, lineNumber, ladder.getHeight());
        }
        return ladder.apply(lines);
    }

    private ArrayList<Line> buildBridge(ArrayList<Line> lines, int lineNumber, int height) {
        for (int position = 0; position < height; position++) {
            if (areLinesOverlapping(lines, lineNumber, position) || !bridgeBuildStrategy.canBuild()) continue;
            lines.get(lineNumber).addBridge(position);
        }
        return lines;
    }

    private boolean areLinesOverlapping(ArrayList<Line> lines, int lineNumber, int position) {
        if (lineNumber - 1 < 0) return false;
        return lines.get(lineNumber-1).isPresent(position);
    }


}
