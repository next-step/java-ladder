package ladder.domain;

import ladder.domain.strategy.CoordinateGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private final List<Direction> line;

    public LadderLine(List<Direction> list) {
        this.line = list;
    }

    public static LadderLine of(People people, CoordinateGenerator coordinateGeneration) {
        Direction direction = Direction.first(coordinateGeneration.generate());
        List<Direction> list = new ArrayList<>();
        list.add(direction);

        for (int i = 1; i < people.count() - 1; i++) {
            direction = direction.next(coordinateGeneration.generate());
            list.add(direction);
        }

        list.add(direction.end());

        return new LadderLine(list);
    }

    public List<Direction> draw() {
        return Collections.unmodifiableList(line);
    }

    public int move(int current) {
        final Direction direction = this.line.get(current);
        return direction.move() + current;

    }
}
