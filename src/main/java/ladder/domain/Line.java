package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Boolean> dots;

    public Line(int userCount, BridgeDecision bridgeDecision) {
        this.dots = initializeDots(userCount, bridgeDecision);
    }

    private static List<Boolean> initializeDots(int count, BridgeDecision bridgeDecision) {
        List<Boolean> values = new ArrayList<>();

        for (int i = 0; i < count-1; i++) {
            values.add( i == 0 ? bridgeDecision.isBridgeTarge() : !values.get(i-1));
        }

        values.add(false);

        return values;
    }

    public String getShapeOfValue(Boolean value) {

        if (value) {
            return "|" + "-".repeat(Player.NAME_MAX_LENGTH);
        }
        return "|" + " ".repeat(Player.NAME_MAX_LENGTH);
    }

    public String getShapeOfLine() {
        return String.join("",
                dots.stream()
                        .map(value -> getShapeOfValue(value))
                        .collect(Collectors.toList()));
    }

    public List<Boolean> getDots() {
        return dots;
    }
}
