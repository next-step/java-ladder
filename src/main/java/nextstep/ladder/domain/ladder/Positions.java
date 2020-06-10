package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Positions {

    private static final int MINIMUM_POSITION_SIZE = 2;

    private final List<Position> positions;

    private Positions(int maxPosition, DirectionPredicate predicate) {
        validate(maxPosition);
        this.positions = createPositions(maxPosition, predicate);
    }

    public List<Position> getPositions() {
        return positions;
    }

    public static Positions newInstance(int maxPosition, DirectionPredicate predicate) {
        return new Positions(maxPosition, predicate);
    }

    private List<Position> createPositions(int maxPosition, DirectionPredicate predicate) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(Direction.generate(predicate)));

        IntStream.range(1, maxPosition)
                .boxed()
                .map(index -> Position.createPosition(index == maxPosition - 1, predicate, positions.get(index - 1)))
                .forEach(positions::add);

        return positions;
    }

    private void validate(int maxPosition) {
        if (maxPosition < MINIMUM_POSITION_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POSITION_SIZE + "입니다.");
        }
    }
}
