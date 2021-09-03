package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private List<Point> steps;

    private Line(List<Point> steps) {
        this.steps = steps;
    }

    public static Line of(List<Boolean> steps) {
        return new Line(transformToPoint(steps));
    }

    private static List<Point> transformToPoint(List<Boolean> steps) {
        List<Point> result = new ArrayList<>();

        // First
        Point first = Point.first(steps.get(1));
        result.add(first);

        // Middle
        Point next = first;
        for (int i = 2; i < steps.size(); i++) {
            next = next.next(steps.get(i));
            result.add(next);
        }
        // Last
        result.add(next.next(false));
        return result;
    }

    public int move(int now) {
        return steps.get(now).move();
    }

    public List<Boolean> getSteps() {
        return steps.stream()
                .map(Point::isLeft)
                .collect(Collectors.toList());

    }

    public int getWidth() {
        return steps.size();
    }
}
