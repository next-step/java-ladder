package ladder.domain;

import ladder.dto.response.LineDto;

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
        return Math.min(
                points.size() - 1,
                points.get(position).move()
        );
    }

    LineDto getLineDto() {
        return points.stream()
                .map(Point::getPointDto)
                .collect(collectingAndThen(toList(), LineDto::new));
    }
}
