package ladder.domain.line;

import ladder.domain.point.LadderPoint;
import ladder.exception.InvalidDirectionException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static ladder.exception.InvalidDirectionException.*;

public class LadderLine implements Iterable<LadderPoint> {
    private final List<LadderPoint> points;

    public LadderLine(final List<LadderPoint> points) {
        validatePoints(points);

        this.points = points;
    }

    public static LadderLineBuilder builder() {
        return new LadderLineBuilder();
    }

    private void validatePoints(final List<LadderPoint> points) {
        if (isPointNotOpened(points)) {
            throw new InvalidDirectionException(ErrorType.NOT_OPENED);
        }
        if (isPointNotClosed(points)) {
            throw new InvalidDirectionException(ErrorType.NOT_CLOSED);
        }
        if (isPointFirstClosed(points)) {
            throw new InvalidDirectionException(ErrorType.FIRST_CLOSED);
        }
        if (isPointLastOpened(points)) {
            throw new InvalidDirectionException(ErrorType.LAST_OPENED);
        }
    }

    private boolean isPointNotOpened(final List<LadderPoint> points) {
        return IntStream.range(1, points.size())
                .anyMatch(index ->
                        points.get(index).isLeft() && !points.get(index - 1).isRight()
                );
    }

    private boolean isPointNotClosed(final List<LadderPoint> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(index ->
                        points.get(index).isRight() && !points.get(index + 1).isLeft()
                );
    }

    private boolean isPointFirstClosed(final List<LadderPoint> points) {
        return points.get(0).isLeft();
    }

    private boolean isPointLastOpened(final List<LadderPoint> points) {
        return points.get(points.size() - 1).isRight();
    }

    public int move(final int index) {
        LadderPoint point = findByIndex(index)
                .orElseThrow(IndexOutOfBoundsException::new);

        return point.move();
    }

    private Optional<LadderPoint> findByIndex(final int index) {
        return points.stream()
                .filter(iPoint -> iPoint.checkIndex(index))
                .findFirst();
    }

    @Override
    public Iterator<LadderPoint> iterator() {
        return points.iterator();
    }
}
