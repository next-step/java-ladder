package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int participantsCount, Random random) {
        IntStream.range(0, participantsCount)
            .forEach(i -> points.add(isNotDrawnBeforePoint(i) && pickAtRandom(random)));
    }

    public boolean hasLine(int position) {
        return points.get(position);
    }

    public boolean isNotDrawnBeforePoint(int index) {
        if (index - 1 < 0) {
            return true;
        }

        return !points.get(index - 1);
    }

    private boolean pickAtRandom(Random random) {
        return random.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line1 = (Line) o;
        return Objects.equals(points, line1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
