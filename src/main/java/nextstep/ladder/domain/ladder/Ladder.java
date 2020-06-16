package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int FIRST_LINE = 0;

    private final List<Line> lines;
    private final Map<Integer, Direction> directionMap;

    public Ladder(Height height, int maxPosition, DirectionPredicate predicate) {
        this.lines = createLines(height, maxPosition, predicate);
        this.directionMap = convertLinesToDirectionMap();
    }

    private List<Line> createLines(Height height, int maxPosition, DirectionPredicate predicate) {
        return IntStream.range(0, height.getHeight())
                .unordered()
                .mapToObj(integer -> Line.newInstance(maxPosition, predicate))
                .collect(Collectors.toList());
    }

    private Map<Integer, Direction> convertLinesToDirectionMap() {
        List<Direction> directions = lines.stream()
                .flatMap(line -> line.getPoints().stream())
                .map(Point::currentDirection)
                .collect(Collectors.toList());

        return IntStream.range(0, directions.size())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), directions::get));
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public Integer getMaxPoint() {
        if (lines.size() > FIRST_LINE) {
            return lines.get(FIRST_LINE).sizeOfPositions();
        }
        return null;
    }

    public int findDestinationPosition(int startPoint) {
        int point = startPoint;
        while (Objects.nonNull(directionMap.get(point))) {
            Direction direction = directionMap.get(point);
            point = nextPosition(point, direction);
        }
        return point % getMaxPoint();
    }

    private int nextPosition(int current, Direction next) {
        return current + next.getDirection() + getMaxPoint();
    }
}
