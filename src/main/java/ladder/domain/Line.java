package ladder.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(int sizeOfPerson, Supplier<Boolean> supplier) {
        DirectionGenerator generator = new DirectionGenerator();
        points = IntStream.range(0, sizeOfPerson)
                .mapToObj(position -> new Point(
                        position,
                        generator.generateDirection(
                                supplier.get()
                        )
                )).collect(Collectors.toList());
    }

    // NOTE: 3단계를 대비하여 미리 만든 함수
    int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return points.stream()
                .map(Point::toString)
                .reduce("", String::concat);
    }
}
