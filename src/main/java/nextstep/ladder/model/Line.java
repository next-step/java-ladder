package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Line {
    private final CoordinateValue heightPosition;
    private Leg leftLeg;
    private Leg rightLeg;

    public Line(int heightPosition) {
        this(new CoordinateValue(heightPosition));
    }

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

        leftLeg = legs.get(CoordinateValue.ZERO);
        rightLeg = legs.get(CoordinateValue.ONE);
        leftLeg.register(this);
        rightLeg.register(this);
    }

    public CoordinateValue getHeightPosition() {
        return heightPosition;
    }

    public Leg getRightLeg() {
        return rightLeg;
    }
}
