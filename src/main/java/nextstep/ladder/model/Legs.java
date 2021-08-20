package nextstep.ladder.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Legs {
    private final List<Leg> legs;

    public Legs(List<Leg> legs) {
        this.legs = legs.stream()
            .sorted(Comparator.comparing(Leg::getWidthPosition))
            .collect(Collectors.toList());
    }

    public Legs(int size, CoordinateValue height) {
         this(
             IntStream.range(0, size)
                 .mapToObj(widthIndex -> new Leg(new CoordinateValue(widthIndex), height))
                 .collect(Collectors.toList())
         );
    }

    public CoordinateValue getHeight() {
        return legs.get(0).getHeight();
    }

    public int size() {
        return legs.size();
    }

    public Leg get(CoordinateValue widthIndex) {
        return legs.get(widthIndex.getValue());
    }

    public Stream<Leg> stream() {
        return legs.stream();
    }
}
