package nextstep.ladder.model;

import java.util.Arrays;

public class Line {
    private final CoordinateValue heightPosition;

    public Line(CoordinateValue heightPosition) {
        this.heightPosition = heightPosition;
    }

    public boolean heightIs(CoordinateValue height) {
        return this.heightPosition.equals(height);
    }

    public void register(Leg ...legs) {
        register(new Legs(Arrays.asList(legs)));
    }

    public void register(Legs legs) {
        if (legs.stream().anyMatch(leg -> leg.hasLine(heightPosition))) {
            return;
        }

        Leg leftLeg = legs.get(CoordinateValue.ZERO);
        leftLeg.register(this);
        Leg rightLeg = legs.get(CoordinateValue.ONE);
        rightLeg.register(this);
    }

    public CoordinateValue getHeightPosition() {
        return heightPosition;
    }
}
