package nextstep.ladder2.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class LineFactory {

    public static Line create(int size) {
        return create(size, GenerateStrategy.randomBooleanSupplier);
    }
    public static Line create(int size, BooleanSupplier generateStrategy) {
        if(size < 1) {
            throw new IllegalArgumentException("생성하는 라인크기는 1이상이어야 합니다.");
        }

        if (generateStrategy == null) {
            throw new IllegalArgumentException("생성 전략은 null이 될 수 없습니다.");
        }

        List<Point> points = new ArrayList<>();
        Point current = Point.first(generateStrategy.getAsBoolean());
        points.add(current);
        if (size == 1) {
            return new Line(points);
        }

        for (int i = 0; i < size - 2; i++) {
            boolean nextValue = generateStrategy.getAsBoolean();
            if (!current.canConnect(nextValue)) {
                nextValue = false;
            }
            current = current.next(nextValue);
            points.add(current);
        }
        points.add(current.last());

        return new Line(points);
    }
}
