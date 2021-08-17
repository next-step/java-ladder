package nextstep.ladder.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Random random = new Random();

    private final List<Leg> legs;
    private final Names names;

    public Ladder(Names names, CoordinateValue height) {
        this.legs = IntStream.range(0, names.size())
            .mapToObj(widthIndex -> new Leg(widthIndex, height))
            .collect(Collectors.toList());
        this.names = names;
    }

    public CoordinateValue getHeight() {
        return legs.get(0).getHeight();
    }

    public CoordinateValue getWidth() {
        return new CoordinateValue(legs.size());
    }

    public Names getNames() {
        return names;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void drawLines() {
        for (int i = 0; i < legs.size() - 1; i++) {
            Leg leftLeg = legs.get(i);
            Leg rightLeg = legs.get(i + 1);
            for (int j = 0; j < getHeight().getValue(); j++) {
                if (random.nextBoolean()) {
                    Line line = new Line(j);
                    line.register(leftLeg, rightLeg);
                }
            }
        }
    }
}
