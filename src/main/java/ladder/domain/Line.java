package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Line {
    private final List<Boolean> points;

    private Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line of(final int countOfPerson, Supplier<Boolean> supplier) {
        List<Boolean> points = new ArrayList<>();
        Boolean beforePoint = Boolean.FALSE;
        for (int i = 0; i < countOfPerson; i++) {
            Boolean point = generatePoint(beforePoint, supplier);
            points.add(point);
            beforePoint = point;
        }
        return new Line(points);
    }

    private static Boolean generatePoint(final Boolean beforePoint, Supplier<Boolean> supplier) {
        if (beforePoint) {
            return Boolean.FALSE;
        }
        return supplier.get();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
