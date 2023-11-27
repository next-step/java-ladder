package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;

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

    public static LadderLine of(People people, CoordinateGenerator coordinateGeneration) {
        /**
         * 사다리 시작점인 왼쪽은 항상 연결되어 있지 않아야 하므로 false로 초기화
         */
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
