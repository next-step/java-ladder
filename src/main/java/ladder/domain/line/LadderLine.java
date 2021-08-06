package ladder.domain.line;

import ladder.domain.point.LadderPoint;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine implements Iterable<LadderPoint> {
    private final List<LadderPoint> points;

    public LadderLine(final List<LadderPoint> points) {
        this.points = points;
    }

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

    public static LadderLine generate(final int pointSize) {
        List<LadderPoint> points =
                Stream.iterate(LadderPoint.first(), LadderPoint::next)
                        .limit(pointSize - 1)
                        .collect(Collectors.toList());
        points.add( // 마지막에 last를 추가해준다.
                points.get(pointSize - 2).last()
        );

        return new LadderLine(points);
    }

    public int size() {
        return points.size();
    }

    @Override
    public Iterator<LadderPoint> iterator() {
        return points.iterator();
    }
}
