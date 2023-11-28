package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private final List<Coordinate> line;

    public LadderLine(List<Coordinate> list) {
        this.line = list;
    }

    public static LadderLine of(People people, CoordinateGenerator coordinateGeneration) {
        List<Coordinate> list = new ArrayList<>();
        Coordinate coordinate = Coordinate.first(coordinateGeneration.generate());
        list.add(coordinate);

        for (int i = 1; i < people.count() - 1; i++) {
            coordinate = coordinate.next(coordinate.isRight(), coordinateGeneration.generate());
            list.add(coordinate);
        }

        list.add(Coordinate.end(coordinate.isRight()));

        return new LadderLine(list);

    }

    public List<Coordinate> draw() {
        return Collections.unmodifiableList(line);
    }

    public int move(int current) {
        final Coordinate coordinate = this.line.get(current);
        return coordinate.move() + current;

    }
}
