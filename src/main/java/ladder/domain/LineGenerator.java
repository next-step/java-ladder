package ladder.domain;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LineGenerator implements Generator<Line> {
    private final int sizeOfPersons;
    private final DirectionStrategy directionStrategy;

    public LineGenerator(int sizeOfPersons, DirectionStrategy directionStrategy) {
        this.sizeOfPersons = sizeOfPersons;
        this.directionStrategy = directionStrategy;
    }

    @Override
    public Line generate() {
        Line line = IntStream.range(0, sizeOfPersons)
                .mapToObj(this::generatePoint)
                .collect(collectingAndThen(toList(), Line::new));
        directionStrategy.reset();
        return line;
    }

    private Point generatePoint(int position) {
        return new Point(
                position,
                directionStrategy.get()
        );
    }
}
