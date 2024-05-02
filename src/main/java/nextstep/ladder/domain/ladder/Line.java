package nextstep.ladder.domain.ladder;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Cross> crosses;

    public static Line of(Boolean... points) {
        List<Cross> crosses = new ArrayList<>();
        Point point = Point.first(() -> points[0]);
        crosses.add(new Cross(0, point));

        for (int i = 1; i < points.length; i++) {
            point = point.next(points[i]);
            crosses.add(new Cross(i, point));
        }

        crosses.add(new Cross(points.length, point.last()));
        return new Line(crosses);
    }

    private Line(List<Cross> crosses) {
        this.crosses = crosses;
    }

    public List<Cross> getCrosses() {
        return crosses;
    }

    public List<Point> getPoints() {
        return crosses.stream().map((Cross::getPoint)).collect(Collectors.toList());
    }

    public int move(int position) {
        return crosses.get(position).move();
    }

    public static Line generate(int userCount) {
        List<Cross> crosses = new ArrayList<>();

        Cross cross = Cross.first();
        crosses.add(cross);
        for (int i = 1; i < userCount; i++) {
            if (i == userCount - 1) {
                cross = cross.last();
            } else {
                cross = cross.next();
            }
            crosses.add(cross);
        }
        return new Line(crosses);
    }

}
