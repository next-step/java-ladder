package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    List<Leg> legs;

    public Ladder(CoordinateValue width, CoordinateValue height) {
        this.legs = IntStream.range(0, width.getValue())
            .mapToObj(widthPosition -> new Leg(widthPosition, height))
            .collect(Collectors.toList());
    }
}
