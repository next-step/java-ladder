package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points = new ArrayList<>();
    private final DirectionGenerator directionGenerator;

    public Line(int sizeOfPerson, DirectionGenerator directionGenerator) {
        this.directionGenerator = directionGenerator;
        create(sizeOfPerson);
    }

    private void create(int sizeOfPerson) {
        Point point = Point.first(directionGenerator.generate());
        points.add(point);

        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(directionGenerator.generate());
            points.add(point);
        }

        points.add(point.last());
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Direction> getDirections() {
        return points.stream().map(Point::getDirection).collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return points.size();
    }
}
