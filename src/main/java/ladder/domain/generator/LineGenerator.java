package ladder.domain.generator;

import ladder.domain.model.Line;
import ladder.domain.model.Point;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LineGenerator implements Generator<Line> {
    private final int sizeOfPersons;
    private final DirectionGenerator directionGenerator;

    public LineGenerator(int sizeOfPersons, DirectionGenerator directionGenerator) {
        this.sizeOfPersons = sizeOfPersons;
        this.directionGenerator = directionGenerator;
    }

    @Override
    public Line generate() {
        Line line = IntStream.range(0, sizeOfPersons)
                .mapToObj(this::generatePoint)
                .collect(collectingAndThen(toList(), Line::new));
        directionGenerator.reset();
        return line;
    }

    private Point generatePoint(int position) {
        return new Point(
                position,
                directionGenerator.generate()
        );
    }
}
