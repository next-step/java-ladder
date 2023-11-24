package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLine {
    private final List<Coordinate> line;

    public LadderLine(List<Coordinate> list) {
        this.line = list;
    }

    public static LadderLine of(People people, CoordinateGeneration coordinateGeneration) {
        Coordinate coordinate = Coordinate.valueOf(false);

        return Stream
                .iterate(coordinate, preCoordinate -> preCoordinate.next(coordinateGeneration.generate()))
                .limit(people.count())
                .collect(collectingAndThen(toList(), LadderLine::new));

    }

    public List<Coordinate> draw() {
        return Collections.unmodifiableList(line);
    }
}
