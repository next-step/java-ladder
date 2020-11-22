package ladder.domain.model;

import ladder.dto.LineDto;
import ladder.exception.BadPositionException;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        // FIXME: Point 의 validate 에 의존하지 않고, 가로 라인이 겹치지 않는지 확인할 방법은 없을까?
        IntStream.range(1, points.size())
                .forEach(position -> points.get(position)
                        .validate(points.get(position - 1))
                );
        this.points = points;
    }

    public int move(int position) {
        int size = points.size();
        if (size <= position) {
            throw BadPositionException.getInstance();
        }
        int moved = points.get(position).move();
        return moved < 0
                ? 0
                : Math.min(size - 1, moved);
    }

    public LineDto exportLineDto() {
        return points.stream()
                .map(Point::exportPointDto)
                .collect(collectingAndThen(toList(), LineDto::new));
    }
}
