package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private List<Line> lines;

    public LadderGame(int height, int userCount, BridgeDecision bridgeDecision) {
        this.lines = initializeLines(height, userCount, bridgeDecision);
    }

    private static List<Line> initializeLines(int height, int userCount, BridgeDecision bridgeDecision) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(userCount, bridgeDecision.isBridgeTarge()));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
