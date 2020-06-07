package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LadderGenerator {

    private int maxPosition;
    private Height height;

    public LadderGenerator(int maxPosition, Height height) {
        this.maxPosition = maxPosition;
        this.height = height;
    }

    public Ladder generate(DirectionPredicate predicate) {
        List<Position> positions = IntStream.range(0, height.getHeight())
                .unordered()
                .boxed()
                .flatMap(height -> createPositions(Height.of(height), Direction.generate(predicate), predicate))
                .collect(toList());

        return new Ladder(positions, height);
    }

    private Stream<Position> createPositions(Height height, Direction direction, DirectionPredicate predicate) {
        return IntStream.range(0, maxPosition)
                .boxed()
                .map(position -> new Position(position, height, new Line(Direction.generate(position, direction, predicate))));
    }
}
