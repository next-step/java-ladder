package nextstep.ladder.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Line {
    private CoordinateValue heightPosition;
    private Leg leftLeg;
    private Leg rightLeg;

    public Line(int heightPosition) {
        this.heightPosition = new CoordinateValue(heightPosition);
    }

    public boolean heightIs(CoordinateValue height) {
        return this.heightPosition.equals(height);
    }

    public void register(Leg ...legs) {
        register(Arrays.asList(legs));
    }

    public void register(List<Leg> legs) {
        if (legs.stream().anyMatch(leg -> leg.hasLine(heightPosition))) {
            throw new IllegalArgumentException("같은 높이에 이미 line 이 있습니다!!");
        }

        legs.sort(Comparator.comparing(Leg::getWidthPosition));
        leftLeg = legs.get(0);
        rightLeg = legs.get(1);
        legs.get(0).register(this);
        legs.get(1).register(this);
    }
}
