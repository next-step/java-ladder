package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Positions {

    private static final int MINIMUM_POSITION_SIZE = 2;

    private final List<Position> positions;

    private Positions(final List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public static Positions newInstance(int maxPosition, DirectionPredicate predicate) {
        validate(maxPosition);
        return new Positions(createPositions(maxPosition, predicate));
    }

    private static List<Position> createPositions(int maxPosition, DirectionPredicate predicate) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(Direction.generate(predicate)));

        IntStream.range(1, maxPosition)
                .boxed()
                .map(index -> createPosition(index, maxPosition - 1, predicate, positions))
                .forEach(positions::add);

        return positions;
    }

    private static Position createPosition(Integer index, int lastPosition,
                                           DirectionPredicate predicate,
                                           List<Position> positions) {
        Position prePosition = positions.get(index - 1);
        if (index == lastPosition) {
            return prePosition.last();
        }
        return prePosition.next(predicate);
    }

    private static void validate(int maxPosition) {
        if (maxPosition < MINIMUM_POSITION_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POSITION_SIZE + "입니다.");
        }
    }
}
