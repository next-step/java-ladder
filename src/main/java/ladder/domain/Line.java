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
