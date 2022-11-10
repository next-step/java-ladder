package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Direction> line = new ArrayList<>();
    private final DirectionGenerator directionGenerator;

    public Line(int people, DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
        create(people);
    }

    private void create(int people) {
        Direction direction = Direction.first(directionGenerator.generate());
        line.add(direction);

        for (int i = 1; i < people - 1; i++) {
            direction = direction.next(directionGenerator.generate());
            line.add(direction);
        }

        line.add(direction.last());
    }

    public List<Direction> getLine() {
        return Collections.unmodifiableList(line);
    }
}
