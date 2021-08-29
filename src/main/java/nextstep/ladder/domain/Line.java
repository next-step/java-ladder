package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final String LESS_THAN_ZERO = "playerCount 값은 0보다 작을 수 없습니다 -> %d";
    private static final String INVALID_POINT = "사다리 지점의 바 생성 방향이 부적절합니다";
    private static final String INVALID_POSITION = "해당 position 에는 Point 가 존재하지 않습니다 -> %d";
    private static final int ZERO = 0;
    private static final Random RANDOM = new Random();

    private final List<Point> points;

    public Line(final int playerCount) {
        validatePlayerCount(playerCount);
        this.points = createPoints(playerCount);
    }

    public Line(final List<Point> points) {
        List<Point> sortedPoints = points.stream()
                .sorted()
                .collect(Collectors.toList());
        validatePoints(sortedPoints);
        this.points = sortedPoints;
    }

    public List<Boolean> getLineBarStatus() {
        return points.stream()
                .map(Point::isRightDirection)
                .limit(points.size() - 1)
                .collect(Collectors.toList());
    }

    public int moveFrom(int position) {
        requiteValidPosition(position);
        return points.get(position)
                .move();
    }

    private List<Point> createPoints(final int playerCount) {
        AtomicBoolean prevBarInstalled = new AtomicBoolean(false);
        return IntStream.range(0, playerCount)
                .mapToObj(i -> new Point(i, Direction.decide(prevBarInstalled.get(), isCurrentInstall(playerCount, i))))
                .peek(point -> prevBarInstalled.set(point.isRightDirection()))
                .collect(Collectors.toList());
    }

    private boolean isCurrentInstall(final int playerCount, final int index) {
        return playerCount - 1 != index
                && RANDOM.nextBoolean();
    }

    private void requiteValidPosition(final int position) {
        if (points.size() - 1 < position) {
            throw new IllegalArgumentException(String.format(INVALID_POSITION, position));
        }
    }

    private void validatePoints(final List<Point> points) {
        boolean isValidPoints = IntStream.range(0, points.size() - 1)
                .filter(i -> !isValidPointDirection(points.get(i), points.get(i + 1)))
                .findAny()
                .isPresent();
        if (isValidPoints) {
            throw new IllegalArgumentException(INVALID_POINT);
        }

    }

    private boolean isValidPointDirection(final Point current, final Point next) {
        return isCurrentRightNextLeft(current, next)
                || isCurrentLeftNextNotLeft(current, next)
                || isCurrentNoneNextNotLeft(current, next);
    }

    private boolean isCurrentNoneNextNotLeft(final Point current, final Point next) {
        return current.isEqualDirection(Direction.NONE) && !next.isEqualDirection(Direction.LEFT);
    }

    private boolean isCurrentLeftNextNotLeft(final Point current, final Point next) {
        return current.isEqualDirection(Direction.LEFT) && !next.isEqualDirection(Direction.LEFT);
    }

    private boolean isCurrentRightNextLeft(final Point current, final Point next) {
        return current.isRightDirection() && next.isEqualDirection(Direction.LEFT);
    }

    private void validatePlayerCount(final int playerCount) {
        if (playerCount < ZERO) {
            throw new IllegalArgumentException(String.format(LESS_THAN_ZERO, playerCount));
        }
    }

}
