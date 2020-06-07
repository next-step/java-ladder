package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MINIMUM_POSITION_SIZE = 2;

    private final Height height;
    private final List<Line> lines;
    private final DirectionPredicate predicate;

    public Ladder(Height height, int maxPosition, DirectionPredicate predicate) {
        validate(maxPosition);
        this.height = height;
        this.predicate = predicate;
        this.lines = createLines(height, maxPosition);

    }

    private List<Line> createLines(Height height, int maxPosition) {
        return IntStream.range(0, height.getHeight())
                .unordered()
                .boxed()
                .map(integer -> new Line(createPositions(maxPosition)))
                .collect(Collectors.toList());
    }

    private List<Position> createPositions(int maxPosition) {

        List<Position> positions = new ArrayList<>();
        IntStream.range(0, maxPosition)
                .mapToObj(position -> createPosition(position, maxPosition, positions))
                .forEach(positions::add);

        return positions;
    }

    private Position createPosition(int position, int maxPosition, List<Position> positions) {
        Direction direction = Direction.generate(predicate);

        if (positions.size() > 0 && position + 1 != maxPosition) {
            Position prePosition = positions.get(position - 1);
            direction = prePosition.getDirection().next(predicate);
        }
        if (position + 1 == maxPosition) {
            Position prePosition = positions.get(position - 1);
            direction = prePosition.getDirection().last();
        }
        return new Position(position, direction);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height.getHeight();
    }

    private void validate(int maxPosition) {
        if (maxPosition < MINIMUM_POSITION_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POSITION_SIZE + "입니다.");
        }
    }
}
