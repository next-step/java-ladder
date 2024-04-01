package ladder.domain;

import ladder.Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private final List<Point> points;

    public Line(int countOfPerson) {
        this(generatePoints(countOfPerson));
  }

    private static List<Point> generatePoints(int countOfPerson) {
        Random random = new Random();
        return Stream.iterate(new Point(random.nextBoolean()),
                        previous -> Lambda.decidePointExist(
                                previous,
                                new Point(random.nextBoolean()),
                                Point::isEqualToTrue)
                )
                .limit(countOfPerson - 1L)
                .collect(Collectors.toList());
    }

    public Line(Boolean... points)  {
        this(Arrays.stream(points).map(Point::new).collect(Collectors.toList()));

    }

    public Line(List<Point> points) {
        IntStream.range(0, points.size()-1)
                .forEach(num ->  Lambda.validatePoint(points.get(num), points.get(num + 1), Point::isEqualToTrue));
        this.points = points;
    }

    public List<Boolean> getLine() {
        return this.points.stream().map(Point::isTrue).collect(Collectors.toList());
    }
}
