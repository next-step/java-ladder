package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HorizontalLine implements Iterable<Boolean> {

    public static final int LAST_LINE = 1;
    private List<Boolean> points = new ArrayList<>();

    public HorizontalLine(int countOfPerson, LineStrategy lineStrategy) {
        for (int i = 0; i < countOfPerson - LAST_LINE; i++) {
            points.add(lineStrategy.add());
        }
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
