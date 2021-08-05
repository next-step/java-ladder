package ladder.domain.line;

import ladder.core.LadderLine;
import ladder.domain.point.LadderPoint;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class BasicLadderLine implements LadderLine, Iterable<LadderPoint> {
    private final List<LadderPoint> points;

    public BasicLadderLine(final List<LadderPoint> points) {
        this.points = points;
    }

    @Override
    public int move(final int index) {
        LadderPoint point = findByIndex(index)
                .orElseThrow(IndexOutOfBoundsException::new);

        return point.move(index);
    }

    private Optional<LadderPoint> findByIndex(final int index) {
        return points.stream()
                .filter(iPoint -> iPoint.checkIndex(index))
                .findFirst();
    }

    @Override
    public int size() {
        return points.size();
    }

    @Override
    public Iterator<LadderPoint> iterator() {
        return points.iterator();
    }
}
