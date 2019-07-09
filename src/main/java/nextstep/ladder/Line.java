package nextstep.ladder;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson, BooleanFunction booleanFunction) {
        List<Point> p = createBody(countOfPerson, booleanFunction);
        return new Line(p);
    }

    private static List<Point> createBody(int countOfPerson, BooleanFunction booleanFunction) {

        return IntStream.range(0, countOfPerson)
                .mapToObj(createBodyFnc(countOfPerson, booleanFunction))
                .collect(Collectors.toList());
    }

    private static IntFunction<Point> createBodyFnc(int countOfPerson, BooleanFunction booleanFunction) {

        AtomicReference<Point> atomicReference = new AtomicReference<>();
        return (index) -> {
            if (index == 0) {
                atomicReference.set(Point.first(booleanFunction));
                return atomicReference.get();
            }

            if (index == countOfPerson - 1) {
                atomicReference.set(atomicReference.get().last());
                return atomicReference.get();
            }

            atomicReference.set(atomicReference.get().next(booleanFunction));
            return atomicReference.get();
        };
    }


    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getMoveIndexByPointIndex(int pointIndex) {
        return this.points.get(pointIndex).move();
    }
}