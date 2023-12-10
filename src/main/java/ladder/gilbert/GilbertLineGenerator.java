package ladder.gilbert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.engine.Line;
import ladder.engine.LineGenerator;
import ladder.gilbert.domain.data.Direction;
import ladder.gilbert.domain.data.Point;

public class GilbertLineGenerator implements LineGenerator {

    private final BooleanGenerator booleanGenerator;

    public GilbertLineGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    @Override
    public Line generate(int numberOfVerticals) {
        Queue<Direction> queue = new LinkedList<>();
        List<Point> points = IntStream.range(0, 2 * numberOfVerticals - 1)
            .mapToObj(idx -> getDirection(idx, queue))
            .map(Point::new)
            .collect(Collectors.toList());
        return new GilbertLine(points);
    }

    private Direction getDirection(int idx, Queue<Direction> queue) {
        if (isEvenIndex(idx)) {
            return Direction.VERTICAL;
        }
        if (lastValueIsHorizontal(queue)) {
            return Direction.NONE;
        }
        if (booleanGenerator.generate()) {
            Direction horizontal = Direction.HORIZONTAL;
            queue.add(horizontal);
            return horizontal;
        }
        return Direction.NONE;
    }

    private boolean isEvenIndex(int idx) {
        return idx % 2 == 0;
    }

    private boolean lastValueIsHorizontal(Queue<Direction> directions) {
        if (directions.isEmpty()) {
            return false;
        }
        return directions.poll().isHorizontal();
    }
}
