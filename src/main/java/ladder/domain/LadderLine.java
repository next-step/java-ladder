package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {
    private final List<Coordinate> line;


    public LadderLine(People people, CoordinateGeneration coordinateGeneration) {
        this(makeLine(people, coordinateGeneration));
    }

    public LadderLine(List<Coordinate> list) {
        this.line = list;
    }

    private static List<Coordinate> makeLine(People people, CoordinateGeneration coordinateGeneration) {
        Coordinate coordinate = Coordinate.valueOf(false);

        return Stream
                .iterate(coordinate, preCoordinate -> preCoordinate.next(coordinateGeneration.generate()))
                .limit(people.count())
                .collect(Collectors.toList());

    }

    public List<Coordinate> draw() {
        return Collections.unmodifiableList(line);
    }
}
