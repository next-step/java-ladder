package nextstep.ladder.model;

import java.util.HashMap;
import java.util.Map;

public class Leg {
    private final Map<CoordinateValue, Line> lines = new HashMap<>();
    private final CoordinateValue widthPosition;
    private final CoordinateValue height;

    public Leg(CoordinateValue widthPosition, CoordinateValue height) {
        this.widthPosition = widthPosition;
        this.height = height;
    }

    public void register(Line line) {
        if (hasLine(line.getHeightPosition())) {
            return;
        }

        lines.put(line.getHeightPosition(), line);
    }

    public boolean hasLine(CoordinateValue height) {
        return lines.containsKey(height);
    }

    public CoordinateValue getWidthPosition() {
        return widthPosition;
    }

    public CoordinateValue getHeight() {
        return height;
    }

    public boolean directlyConnected(Leg otherLeg, CoordinateValue heightIndex) {
        Line my = lines.get(heightIndex);
        Line other = otherLeg.lines.get(heightIndex);

        if (my == null || other == null) {
            return false;
        }
        return my.equals(other);
    }

    public int getLinesSize() {
        return lines.size();
    }
}
