package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {

        points.add(false);

        Random random = new Random();
        points.add(random.nextBoolean());

        for (int i = 2; i < countOfPerson; i++) {
            Boolean current = random.nextBoolean();
            points.add(isCurrentAdd(points.get(i - 1), current));

        }
    }

    private Boolean isCurrentAdd(Boolean before, Boolean current) {
        if (before != current) {
            return current;
        }
        return !current;
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public int getSize() {
        return points.size();
    }

    public boolean isDraw(int i) {
        return points.get(i);
    }
}
