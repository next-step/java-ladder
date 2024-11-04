package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private List<Line> lines;

    public LadderGame(int height, int userCount) {
        this.lines = initializeLines(height, userCount);
    }

    private static List<Line> initializeLines(int height, int userCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(userCount));
        }
        return lines;
    }

    public void buildLines(BridgeDecision bridgeDecision) {
        lines.stream()
                .forEach(line -> line.buildLine(bridgeDecision.isBridgeTarge()));
    }

    public List<Line> getLines() {
        return lines;
    }
}
