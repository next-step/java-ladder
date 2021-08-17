package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Leg {
    private final List<Line> lines = new ArrayList<>();
    private final CoordinateValue widthPosition;
    private final CoordinateValue height;

    public Leg(CoordinateValue widthPosition, CoordinateValue height) {
        this.widthPosition = widthPosition;
        this.height = height;
    }

    public Leg(int widthPosition, int height) {
        this(new CoordinateValue(widthPosition), new CoordinateValue(height));
    }

    public Leg(int widthPosition, CoordinateValue height) {
        this(new CoordinateValue(widthPosition), height);
    }

    public boolean hasLine(CoordinateValue height) {
        return lines.stream().anyMatch(line -> line.heightIs(height));
    }

    public void register(Line line) {
        if (hasLine(line.getHeightPosition())) {
            return;
        }

        lines.add(line);
    }

    public CoordinateValue getWidthPosition() {
        return widthPosition;
    }

    public CoordinateValue getHeight() {
        return height;
    }

    public boolean directlyConnected(Leg rightLeg, CoordinateValue heightIndex) {
        return lines.stream().filter(line -> line.heightIs(heightIndex)).anyMatch(line -> line.getRightLeg().widthPosition.equals(rightLeg.widthPosition));
    }
}
