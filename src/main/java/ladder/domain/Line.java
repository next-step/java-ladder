package ladder.domain;

import ladder.dto.LineDto;
import ladder.exception.BadPositionException;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Line {
    private final List<Point> points;

    public Line(int sizeOfPersons, Supplier<Boolean> supplier) {
        DirectionGenerator generator = new DirectionGenerator();
        points = IntStream.range(0, sizeOfPersons)
                .mapToObj(position -> new Point(
                        position,
                        generator.generateDirection(
                                supplier.get()
                        )
                )).collect(Collectors.toList());
    }

    int move(int position) {
        int size = points.size();
        if (size <= position) {
            throw BadPositionException.getInstance();
        }
        return Math.min(
                size - 1,
                points.get(position).move()
        );
    }

    LineDto exportLineDto() {
        return points.stream()
                .map(Point::exportPointDto)
                .collect(collectingAndThen(toList(), LineDto::new));
    }
}
