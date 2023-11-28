package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

    private final BooleanGenerator booleanGenerator;

    public LineGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Line generate(int numberOfPeople) {
        Queue<Direction> queue = new LinkedList<>();
        List<Point> points = IntStream.range(0, 2 * numberOfPeople - 1)
            .mapToObj(idx -> getDirection(idx, queue))
            .map(Point::new)
            .collect(Collectors.toList());
        return new Line(points);
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
