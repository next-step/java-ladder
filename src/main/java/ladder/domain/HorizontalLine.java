package ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HorizontalLine implements Iterable<Boolean> {

    private static final int LAST_LINE = 1;

    private final List<Boolean> points;

    public HorizontalLine(int countOfPerson, LineStrategy lineStrategy) {
        this(IntStream.rangeClosed(1, countOfPerson - LAST_LINE)
            .mapToObj(i -> lineStrategy.add())
            .collect(Collectors.toList()));
    }

    public HorizontalLine(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HorizontalLine that = (HorizontalLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public Iterator<Boolean> iterator() {
        return points.iterator();
    }

}
