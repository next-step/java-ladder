package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLineGenerator implements LineGenerator {

    @Override
    public Line generate(int lineSize) {
        List<Point> points = new ArrayList<>(lineSize);

        while (points.stream().filter(p -> p.hasDirectionType(DirectionType.NONE)).count() == points.size()) {
            points = this.createPoints(lineSize);
        }

        return new Line(points);
    }

    private List<Point> createPoints(int lineSize) {
        Supplier<Movable> simpleMovableSupplier = () -> Math.round(Math.random()) == 1 ?  Movable.TRUE : Movable.FALSE;
        Function<Boolean, Movable> nextMovableSupplier = currentMovable -> {
            if (currentMovable) {
                return Movable.FALSE;
            }

            return simpleMovableSupplier.get();
        };

        List<Point> points = new ArrayList<>(lineSize);

        // first
        points.add(Point.first(simpleMovableSupplier.get()));

        // middle
        IntStream.rangeClosed(1, lineSize - 1)
                .mapToObj(i -> points.add(points.get(i - 1).next(nextMovableSupplier.apply(points.get(i-1).hasMoveDirection()))))
                .collect(Collectors.toList());

        // last
        points.add(points.get(lineSize - 1).last());

        return points;
    }
}
