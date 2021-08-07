package ladder.domain.line;

import ladder.domain.point.LadderPoint;
import ladder.exception.InvalidDirectionException;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class LadderLine implements Iterable<LadderPoint> {
    private final List<LadderPoint> points;

    public LadderLine(final List<LadderPoint> points) {
        validatePoints(points);

        this.points = points;
    }

    private void validatePoints(final List<LadderPoint> points) {
        if (isPointNotOpened(points)) {
            throw new InvalidDirectionException("왼쪽으로 닫혀있는 줄은 바로 전줄에서 열었어야 합니다.");
        }
        if (isPointNotClosed(points)) {
            throw new InvalidDirectionException("오른쪽으로 열려있는 줄은 바로 다음줄에서 닫아야 합니다.");
        }
        if (isPointFirstClosed(points)) {
            throw new InvalidDirectionException("첫번째 줄은 닫힐 수 없습니다.");
        }
        if (isPointLastOpened(points)) {
            throw new InvalidDirectionException("마지막 줄은 열려있을 수 없습니다.");
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

    public static LadderLineBuilder builder() {
        return new LadderLineBuilder();
    }

    private Optional<LadderPoint> findByIndex(final int index) {
        return points.stream()
                .filter(iPoint -> iPoint.checkIndex(index))
                .findFirst();
    }

    public int size() {
        return points.size();
    }

    @Override
    public Iterator<LadderPoint> iterator() {
        return points.iterator();
    }
}
